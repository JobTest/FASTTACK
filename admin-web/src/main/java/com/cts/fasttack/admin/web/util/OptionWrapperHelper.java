package com.cts.fasttack.admin.web.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import com.cts.fasttack.admin.web.data.OptionWrapperDto;
import com.cts.fasttack.crypto.client.dict.Dict;

/**
 * Helper for {@link OptionWrapperDto}
 *
 * @author n.bizin
 */
public class OptionWrapperHelper {

    /**
     * Create list option wrappers from {@link Dict} values
     *
     * @param dictValues dict values
     * @return {@link List}&lt;{@link OptionWrapperDto}&gt;
     */
    public static List<OptionWrapperDto> getDictOptionWrappers(Dict[] dictValues) {
        return Arrays.stream(dictValues)
                .map(d -> new OptionWrapperDto(d.getKey(), d.getCaption()))
                .collect(Collectors.toList());
    }

    public static List<OptionWrapperDto> getI18DictOptionWrappers(Dict[] dictValues) {
        return Arrays.stream(dictValues)
                .map(d -> new OptionWrapperDto(d.getKey(), getI18DictCaption(d)))
                .collect(Collectors.toList());
    }

    private static String getI18DictCaption(Dict dict) {
        String key = dict.getClass().getSimpleName() + "." + dict.getKey();
        return ApplicationContextHolder.getBean(MessageSource.class).getMessage(key, null, LocaleContextHolder.getLocale());
    }
}
