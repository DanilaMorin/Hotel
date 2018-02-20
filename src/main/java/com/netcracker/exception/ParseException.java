package com.netcracker.exception;

/**
 * Created by user on 20.02.2018.
 */
public class ParseException  extends TraceException{
    public ParseException(String string) {
        super(string);
    }

    @Override
    public ExceptionInfo getExceptionInfo() {
        return super.getExceptionInfo();
    }
}
