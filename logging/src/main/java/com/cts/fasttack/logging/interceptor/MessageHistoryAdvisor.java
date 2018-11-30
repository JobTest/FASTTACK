package com.cts.fasttack.logging.interceptor;

import java.lang.reflect.Method;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Pointcut;
import org.springframework.aop.support.AbstractPointcutAdvisor;
import org.springframework.aop.support.StaticMethodMatcherPointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.BridgeMethodResolver;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;

@Component
public class MessageHistoryAdvisor extends AbstractPointcutAdvisor {

	private static final long serialVersionUID = -2013715326304102269L;

	private static final Pointcut POINTCUT = new StaticMethodMatcherPointcut() {
        @Override
        public boolean matches(Method method, Class<?> targetClass) {
            if (method.isAnnotationPresent(MessageHistoryOperation.class)) {
                return true;
            }

            Class<?> specificClass = ClassUtils.isCglibProxyClass(targetClass) && targetClass.getSuperclass() != null ? targetClass.getSuperclass() : targetClass;

            Method specificMethod = ClassUtils.getMostSpecificMethod(method, specificClass);

            // If we are dealing with method with generic parameters, find the original method.
            specificMethod = BridgeMethodResolver.findBridgedMethod(specificMethod);

            // The method may be on an interface, so let's check on the target class as well.
            return (specificMethod != method && specificMethod.isAnnotationPresent(MessageHistoryOperation.class));
        }
    };

    @Autowired
    private MessageHistoryInterceptor interceptor;

    @Override
    public Pointcut getPointcut() {
        return POINTCUT;
    }

    @Override
    public Advice getAdvice() {
        return interceptor;
    }
}
