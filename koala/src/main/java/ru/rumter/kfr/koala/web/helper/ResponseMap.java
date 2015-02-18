package ru.rumter.kfr.koala.web.helper;

import java.util.HashMap;

public class ResponseMap<T> extends HashMap<String, Object> {

    private static final String KEY_STATUS = "status";
    private static final String KEY_DATA = "data";
    private static final String EXCEPTION_CLASS = "exceptionClass";
    private static final String KEY_MESSAGE = "message";

    public String getStatus() {
        return (String) get(KEY_STATUS);
    }

    public void setStatus(ResponseStatusEnum status) {
        put(KEY_STATUS, status.getValue());
    }

    public T getData() {
        return (T) get(KEY_DATA);
    }

    public void setData(T data) {
        put(KEY_DATA, data);
    }

    public String getExceptionClass() {
        return (String) get(EXCEPTION_CLASS);
    }

    public void setExceptionClass(Class exceptionClass) {
        put(EXCEPTION_CLASS, exceptionClass.getCanonicalName());
    }

    public String getMessage() {
        return (String) get(KEY_MESSAGE);
    }

    public void setMessage(String message) {
        put(KEY_MESSAGE, message);
    }

}