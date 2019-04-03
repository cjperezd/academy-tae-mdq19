package com.academy.mdq.services.dtos.response;

public class Response<T> {
    private int status;
    private T payload;

    public Response(int status, T payload) {
        this.status = status;
        this.payload = payload;
    }

    public int getStatus() {
        return status;
    }

    public T getPayload() {
        return payload;
    }
}