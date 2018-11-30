package com.cts.fasttack.jms.data;

/**
 * The strategy for adding a message to the queue
 *
 * @author Dmitry Koval
 */
public enum DuplicateDetectionStrategy {

    /**
     * Ignore duplicate checks and add to the queue
     */
    IGNORE_DUBLICATE,

    /**
     * Delete and cancel processing message
     */
    CANCEL_PROCESSING;

}
