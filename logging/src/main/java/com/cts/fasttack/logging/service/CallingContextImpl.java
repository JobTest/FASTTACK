package com.cts.fasttack.logging.service;

import org.springframework.stereotype.Service;
import com.cts.fasttack.common.core.data.ProcessingArea;

/**
 * @author Dmitry Koval
 */
@Service("callingContext")
public class CallingContextImpl implements CallingContext {

    private ThreadLocal<CallingContextData> currentContextData = new ThreadLocal<>();

    @Override
    public void setContext(String originator) {
        currentContextData.set(new CallingContextData(originator));
    }

    @Override
    public String getOriginator() {
        CallingContextData contextData = currentContextData.get();
        if (contextData == null) {
            return null;
        }
        return contextData.getOriginator();
    }

    @Override
    public ProcessingArea getProcessingArea() {
        CallingContextData contextData = currentContextData.get();
        if (contextData == null) {
            return null;
        }
        return contextData.getProcessingArea();
    }

    @Override
    public void setProcessingArea(ProcessingArea processingArea) {
        CallingContextData contextData = currentContextData.get();
        if (contextData == null) {
            throw new IllegalStateException("CallingContext isn't initialized. Call method setContext(..) first.");
        }
        contextData.setProcessingArea(processingArea);
    }

    @Override
    public void clean() {
        currentContextData.remove();
    }

    private static class CallingContextData {

        private String originator;

        private ProcessingArea processingArea;

        public CallingContextData(String originator) {
            this.originator = originator;
        }

        public ProcessingArea getProcessingArea() {
            return processingArea;
        }

        public void setProcessingArea(ProcessingArea processingArea) {
            this.processingArea = processingArea;
        }

        public String getOriginator() {
            return originator;
        }
    }
}
