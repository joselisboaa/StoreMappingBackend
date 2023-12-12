package com.map.store.api.exception;

import lombok.Data;

import java.io.Serializable;

@Data
public class StandardError implements Serializable {
    private static final long serialVersionUID = 1L;
    private String error;
    private String message;
    private String details;

    public StandardError(String error, String message, String details) {
        this.error = error;
        this.message = message;
        this.details = details;
    }
}

