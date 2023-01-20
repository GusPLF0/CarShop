package com.gus.carshop.exception;

import java.io.Serializable;
import java.util.Date;

public class ApiErrorMessage implements Serializable {

    private Date timestamp;
    private String message;
    private String details;

    public ApiErrorMessage(Date timestamp, String message, String details) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }
}
