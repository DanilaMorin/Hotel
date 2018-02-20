package com.netcracker.exception;

/**
 * Created by user on 15.02.2018.
 */
public class EntityNotFound extends TraceException {

    public EntityNotFound(String string) {
        super(string);
    }

    @Override
    public ExceptionInfo getExceptionInfo() {
        return super.getExceptionInfo();
    }
}
