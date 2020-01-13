package com.gemalto.telecom.ota.greet.api.exceptions;

import com.gemalto.telecom.components.exception.ApplicativeException;

public class IllegalDummyStateException extends ApplicativeException {

    private static final int ERROR_CODE = 100;
    public static final int HTTP_CODE = 409;
    private static final String MESSAGE = "Dummy state '%s' is not allowed";
    public static final String DESCRIPTION = "Dummy state not authorized (Error:" + ERROR_CODE + ")";

    public IllegalDummyStateException(final String state) {
        super(String.format(MESSAGE, state));
    }

    @Override
    public int getErrorCode() {
        return ERROR_CODE;
    }

    @Override
    public int getStatusCode() {
        return HTTP_CODE;
    }
}
