package ru.rumter.kfr.koala.web.helper;

public class ResponseUtils {

    public static <T> ResponseMap<T> successResponse(T response) {
        ResponseMap<T> map = new ResponseMap<>();
        map.setStatus(ResponseStatusEnum.SUCCESS);
        map.setData(response);
        return map;
    }

    public static ResponseMap<Void> successResponse() {
        ResponseMap<Void> map = new ResponseMap<>();
        map.setStatus(ResponseStatusEnum.SUCCESS);
        return map;
    }

    public static ResponseMap<Void> errorResponse(Exception e) {
        ResponseMap<Void> map = new ResponseMap<>();
        map.setStatus(ResponseStatusEnum.ERROR);
        map.setMessage(e.getMessage());
        if (e instanceof RuntimeException) {
            map.setExceptionClass(e.getClass());
        } else {
            map.setExceptionClass(RuntimeException.class);
        }
        return map;
    }

}