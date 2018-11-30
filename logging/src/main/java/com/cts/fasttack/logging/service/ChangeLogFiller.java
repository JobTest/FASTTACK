package com.cts.fasttack.logging.service;

import com.cts.fasttack.logging.dto.ChangeLogItem;

/**
 * The procedure for filling in the entry fields in CHANGELOG
 *
 * @author Dmitry Koval
 */
public interface ChangeLogFiller {
    void fill(ChangeLogItem item);

}
