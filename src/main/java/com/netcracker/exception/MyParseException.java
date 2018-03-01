package com.netcracker.exception;

/**
 * Created by user on 20.02.2018.
 */
public class MyParseException extends TraceException {
    public MyParseException(String string) {
        super(string);
    }

    @Override
    public ExceptionInfo getExceptionInfo() {
        return super.getExceptionInfo();
    }
}
