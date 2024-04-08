package com.vemser.rest.tests.basic.pojo.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProdutoResponse {
    private String message;
    @JsonProperty("_id")
    private String id;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ProdutoResponse{" +
                "message='" + message + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
