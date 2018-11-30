package com.cts.fasttack.common.core.util;

import com.cts.fasttack.common.core.dict.TokenizationPath;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Optional;

public class TokenizationPathUtil {

    public static TokenizationPath identify(String recommendedDecision, String[] recommendationReasons) {
        TokenizationPath recommendationReasonsPath = identify(recommendationReasons);
        TokenizationPath recommendedDecisionPath = identify(recommendedDecision);

        if (isRecommendationReasons(recommendationReasons)) {
            return recommendationReasonsPath;
        } else if (isRecommendedDecision(recommendedDecision, recommendationReasonsPath)) {
            return recommendedDecisionPath;
        }
        return TokenizationPath.YELLOW;
    }

    public static TokenizationPath identify(String[] recommendationReasons) {
        recommendationReasons = Optional.ofNullable(recommendationReasons).orElse(new String[]{});

        boolean isGreen = Arrays.asList(recommendationReasons).containsAll(Arrays.asList("APPROVED"));
        boolean isRed = Arrays.asList(recommendationReasons).containsAll(Arrays.asList("DECLINED"));
        boolean isOrange = Arrays.asList(recommendationReasons).containsAll(Arrays.asList("HIGH_RISK")) || Arrays.asList(recommendationReasons).containsAll(Arrays.asList("0G"));

        if (isOrange) return TokenizationPath.ORANGE;
        else if (isGreen) return TokenizationPath.GREEN;
        else if (isRed) return TokenizationPath.RED;
        return TokenizationPath.YELLOW;
    }

    public static TokenizationPath identifyCodes(String[] reasonCodes) {
        reasonCodes = Optional.ofNullable(reasonCodes).orElse(new String[]{});

        boolean isOrange = Arrays.asList(reasonCodes).containsAll(Arrays.asList("0G"));

        if (isOrange) return TokenizationPath.ORANGE;
        return TokenizationPath.YELLOW;
    }

    private static TokenizationPath identify(String recommendedDecision) {
        recommendedDecision = Optional.ofNullable(recommendedDecision).orElse("");

        TokenizationPath tokenizationPath = TokenizationPath.YELLOW;

        switch (recommendedDecision) {
            case "HIGH_RISK" : {
                tokenizationPath = TokenizationPath.ORANGE;
                break;
            }
            case "0G" : {
                tokenizationPath = TokenizationPath.ORANGE;
                break;
            }
            case "APPROVED" : {
                tokenizationPath = TokenizationPath.GREEN;
                break;
            }
            case "DECLINED" : {
                tokenizationPath = TokenizationPath.RED;
                break;
            }
        }
        return tokenizationPath;
    }

    private static boolean isRecommendationReasons(String[] recommendationReasons) {
        return recommendationReasons != null && 0 < recommendationReasons.length;
    }

    private static boolean isRecommendedDecision(String recommendedDecision, TokenizationPath recommendationReasonsPath) {
        return StringUtils.isNotBlank(recommendedDecision) && recommendationReasonsPath != TokenizationPath.ORANGE;
    }
}
