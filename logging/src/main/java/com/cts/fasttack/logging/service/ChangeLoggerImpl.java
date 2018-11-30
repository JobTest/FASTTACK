package com.cts.fasttack.logging.service;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cts.fasttack.logging.domain.ChangeLog;
import com.cts.fasttack.logging.domain.dict.LogSeverity;
import com.cts.fasttack.logging.service.CallingContext;
import com.cts.fasttack.logging.service.ChangeLogFiller;
import com.cts.fasttack.logging.service.ChangeLogService;
import com.cts.fasttack.logging.service.ChangeLogger;

/**
 * @author Dmitry Koval
 */
@Service("changeLogger")
public class ChangeLoggerImpl implements ChangeLogger {
    @Autowired
    private CallingContext callingContext;

    @Autowired
    private ChangeLogService changeLogService;

    @Override
    public void info(String action, ChangeLogFiller filler) {
        log(action, filler, LogSeverity.INFO);
    }

    @Override
    public void warn(String action, ChangeLogFiller filler) {
        log(action, filler, LogSeverity.WARN);
    }

    @Override
    public void error(String action, ChangeLogFiller filler) {
        log(action, filler, LogSeverity.ERROR);
    }

    @Override
    public void log(String action, ChangeLogFiller filler, LogSeverity severity) {
        ChangeLog log = new ChangeLog();
        log.setAction(action);
        filler.fill(log);
        String originator = log.getOriginator();
        if (StringUtils.isBlank(originator)) {
            originator = callingContext.getOriginator();
            log.setOriginator(originator);
        }
        if (originator == null) {
            throw new IllegalStateException("Unable to define originator. CallingContext isn't initialized for the current thread.");
        }
        log.setSeverity(severity);
        log.setTime(new Date());
        changeLogService.save(log);
    }
}
