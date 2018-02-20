package com.netcracker.exception;

/**
 * Created by user on 15.02.2018.
 */
public class TraceException extends Exception {
    private ExceptionInfo exceptionInfo = new ExceptionInfo();

    public TraceException(String string) {
        super(string);
    }

    public TraceException(Throwable thrwbl) {
        super(thrwbl);
    }

    public TraceException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public ExceptionInfo getExceptionInfo() {
        exceptionInfo.setTrace(getStringFromTrace(getStackTrace()));
        return exceptionInfo;
    }

    private String getStringFromTrace(StackTraceElement[] stackTrace) {
        StringBuilder builder = new StringBuilder();
        builder.append("\n");
        for (StackTraceElement stackTraceElement : stackTrace) {
            builder.append(stackTraceElement.toString()).append("\n");
        }

        return builder.toString();
    }
}
