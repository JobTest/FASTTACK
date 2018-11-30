package com.cts.fasttack.admin.web.data;

import com.cts.fasttack.crypto.client.dict.Dict;

/**
 * DTO for options of the select2 control
 */
public class OptionWrapperDto implements Dict, Comparable<OptionWrapperDto> {

	private static final long serialVersionUID = 5639253962204292053L;

	private String key;

    private String caption;

    public OptionWrapperDto() {}

    public OptionWrapperDto(String key, String caption) {
        this.key = key;
        this.caption = caption;
    }

    @Override
    public int compareTo(OptionWrapperDto o) {
        if (caption == null && o.caption == null) {
            return 0;
        }
        if (caption != null && o.caption == null) {
            return 1;
        }
        if (caption == null) {
            return -1;
        }
        return caption.compareTo(o.caption);
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
