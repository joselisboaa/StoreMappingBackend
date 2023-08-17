package com.map.store.api.exception;

import lombok.Data;

import java.io.Serializable;

@Data
public class StandardError implements Serializable {
    private static final long serialVersionUID = 1L;
    private String error;
    private String message;

    public StandardError(String error, String message) {
        this.error = error;
        this.message = message;
    }
}

