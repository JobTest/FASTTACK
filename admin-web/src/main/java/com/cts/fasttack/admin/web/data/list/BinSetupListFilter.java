package com.cts.fasttack.admin.web.data.list;

import javax.validation.constraints.Pattern;

import com.cts.fasttack.admin.web.data.dto.BinSetupDto;
import com.cts.fasttack.common.core.list.ListFilter;

/**
 * @author a.lipavets
 */
public class BinSetupListFilter extends ListFilter<BinSetupDto> {
    @Pattern(regexp = "\\d+", message = "{bin.invalid}")
    private String bin;

    public String getBin() {
        return bin;
    }

    public void setBin(String bin) {
        this.bin = bin;
    }
}
