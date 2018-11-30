package com.cts.fasttack.logging.interceptor;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.core.ParameterNameDiscoverer;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.EvaluationException;
import org.springframework.expression.Expression;
import org.springframework.expression.ParseException;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import com.cts.fasttack.common.core.exception.ServiceException;

/**
 * Utility class handling the SpEL expression parsing.
 * Meant to be used as a reusable, thread-safe component.
 *
 * <p>Performs internal caching for performance reasons.
 *
 * Used from Spring Cache
 */
public class ExpressionEvaluator {

    static final ExpressionEvaluator INSTANCE = new ExpressionEvaluator();

    private final SpelExpressionParser parser = new SpelExpressionParser();

    // shared param discoverer since it caches data internally
    private final ParameterNameDiscoverer paramNameDiscoverer = new LocalVariableTableParameterNameDiscoverer();

    private final Map<String, Expression> expCache = new ConcurrentHashMap<>();

    private final Map<String, Expression> fieldExpCache = new ConcurrentHashMap<>();

    private final Map<String, Method> targetMethodCache = new ConcurrentHashMap<>();

    public EvaluationContext createEvaluationContext(Method method, Object[] args, Object result, Class<?> targetClass) {
        return new LazyParamAwareEvaluationContext(this.paramNameDiscoverer, method, args, result, targetClass, this.targetMethodCache);
    }

    public Object evaluateExpression(String expression, Method method, EvaluationContext evalContext) throws ServiceException {
        return evaluateExpression(method, expression, evalContext, this.expCache);
    }

    public String[] fields(String[] fieldExpressions, Method method, EvaluationContext evalContext) {
        String[] result = new String[fieldExpressions.length];
        for (int i = 0; i < fieldExpressions.length; i++) {
            String fieldExpression = fieldExpressions[i];
            Object value = evaluateExpression(method, fieldExpression, evalContext, this.fieldExpCache);
            result[i] = value != null ? value.toString() : null;
        }
        return result;
    }

    private Object evaluateExpression(Method method, String expression, EvaluationContext evalContext, Map<String, Expression> cache) {
        try {
            String key = toString(method, expression);
            Expression fieldExp = cache.get(key);
            if (fieldExp == null) {
                fieldExp = this.parser.parseExpression(expression);
                cache.put(key, fieldExp);
            }
            return fieldExp.getValue(evalContext);
        } catch (ParseException | EvaluationException e) {
            throw new RuntimeException("Error evaluating expression '" + expression + "'", e);
        }
    }

    private String toString(Method method, String expression) {
        return method.getDeclaringClass().getName() + "#" + method.toString() + "#" + expression;
    }
}
