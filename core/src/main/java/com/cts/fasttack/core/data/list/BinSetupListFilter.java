package com.cts.fasttack.core.data.list;

import com.cts.fasttack.common.core.list.ListFilter;
import com.cts.fasttack.core.data.BinSetup;

/**
 * @author a.lipavets
 */
public class BinSetupListFilter extends ListFilter<BinSetup> {

    private Long bin;

    public Long getBin() {
        return bin;
    }

    public void setBin(Long bin) {
        this.bin = bin;
    }
}
