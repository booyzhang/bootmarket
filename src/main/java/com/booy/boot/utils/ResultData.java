package com.booy.boot.utils;

public class ResultData {
    private Boolean status;
    private String message;

    public ResultData(Boolean status, String message) {
        this.status = status;
        this.message = message;
    }

    public ResultData(Boolean status) {
        this.status = status;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
