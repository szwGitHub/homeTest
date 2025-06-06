package com.example.entity;


import lombok.Data;

@Data
public class RestBean<T> {

    private int status;

    private boolean success;

    private T message;

    public RestBean(int status, boolean success, T message) {
        this.status = status;
        this.success = success;
        this.message = message;
    }

    public static <T> RestBean<T> success() {
        return new RestBean<>(200,true,null);
    }
    public static <T> RestBean<T> success(T message) {
        return new RestBean<>(200,true,message);
    }
    public static <T> RestBean<T> failure(int status) {
        return new RestBean<>(status,false,null);
    }
    public static <T> RestBean<T> failure(int status, T message) {
        return new RestBean<>(status,false,message);
    }
}
