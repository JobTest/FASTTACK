package com.cts.fasttack.logging.service;

import com.cts.fasttack.logging.domain.dict.LogSeverity;

/**
 * Service for logging in CHANGELOG
 *
 * @author Dmitry Koval
 */
public interface ChangeLogger {

    void info(String action, ChangeLogFiller filler);

    void warn(String action, ChangeLogFiller filler);

    void error(String action, ChangeLogFiller filler);

    void log(String action, ChangeLogFiller filler, LogSeverity severity);
}
