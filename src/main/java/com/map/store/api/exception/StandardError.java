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

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
}

