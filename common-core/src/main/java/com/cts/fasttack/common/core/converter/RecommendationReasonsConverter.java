package com.cts.fasttack.common.core.converter;

import com.cts.fasttack.common.core.dict.RecommendationReasons;
import com.cts.fasttack.common.core.dict.RecommendationReasonsCode;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class RecommendationReasonsConverter {

    public RecommendationReasonsCode convert(RecommendationReasons recommendationReasons) {
        return RecommendationReasonsCode.valueOf(recommendationReasons.name());
    }

    public RecommendationReasons convert(RecommendationReasonsCode recommendationReasonsCode) {
        return RecommendationReasons.valueOf(recommendationReasonsCode.name());
    }

    public String convertToReasonCodes(String[] reasons) {

        reasons = Optional.ofNullable(reasons).orElse(new String[]{});
        String[] codes = Arrays.asList(reasons).stream()
                .map(arg -> convert(RecommendationReasons.valueOf(arg)).getCode())
                .collect(Collectors.toList())
                .toArray(new String[reasons.length]);

        return Arrays.toString(codes)
                .replace("[","").replace("]","").replace(" ","");
    }

    public String[] convertToReasons(String reasonCodes) {
        reasonCodes = Optional.ofNullable(reasonCodes).orElse("");
        reasonCodes = reasonCodes.replace("[","").replace("]","").replace(" ","");
        String[] codes = reasonCodes.split(",");

        List<String> list = Arrays.asList(codes).stream()
                .filter(code -> StringUtils.isNoneBlank(code) && RecommendationReasonsCode.valueOfCode(code)!=null)
                .map(code -> convert(RecommendationReasonsCode.valueOfCode(code)).getValue())
                .collect(Collectors.toList());
        return list.toArray(new String[list.size()]);
    }

    public String[] convert(String reasonCodes) {
        reasonCodes = Optional.ofNullable(reasonCodes).orElse("");
        reasonCodes = reasonCodes.replace("[", "").replace("]", "").replace(" ", "");
        return reasonCodes.split(",");
    }
}
