package com.netcracker.exception;

/**
 * Created by user on 20.02.2018.
 */
public class ErrorValidation extends TraceException {
    public ErrorValidation(String string) {
        super(string);
    }
    @Override
    public ExceptionInfo getExceptionInfo() {
        return super.getExceptionInfo();
    }
}
