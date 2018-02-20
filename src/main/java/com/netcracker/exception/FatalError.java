package com.netcracker.exception;

/**
 * Created by user on 15.02.2018.
 */
public class FatalError extends TraceException {
    public FatalError(String string) {
        super(string);
    }

    @Override
    public ExceptionInfo getExceptionInfo() {
        return super.getExceptionInfo();
    }
}
