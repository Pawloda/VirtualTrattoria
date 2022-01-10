package com.damian.virtualtrattoria.exception;

/**
 * Business Exception contained the message for the user of the application.
 *
 * @author Damian
 * @version 1.0
 * @since 04.01.2022
 */
public class BusinessException extends RuntimeException {

    public BusinessException(final String message) {
        super(message);
    }

}