package com.cts.fasttack.logging.service;


import com.cts.fasttack.common.core.data.ProcessingArea;

/**
 * Stores information about the calling party: application.
 * The data is relevant for the current Thread.
 */
public interface CallingContext {

    void setContext(String originator);

    String getOriginator();

    ProcessingArea getProcessingArea();

    void setProcessingArea(ProcessingArea processingArea);

    void clean();

}
