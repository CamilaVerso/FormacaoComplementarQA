package com.vemser.rest.tests.basic.pojo.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UsuarioResponse {

    private String message;
    @JsonProperty("_id") //assim porque não pode ter _ no começo da palavra
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
        return "Response{" +
                "message='" + message + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
