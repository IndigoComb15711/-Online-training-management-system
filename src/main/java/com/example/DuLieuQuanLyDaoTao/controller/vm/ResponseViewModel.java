package com.example.DuLieuQuanLyDaoTao.controller.vm;

public class ResponseViewModel {
    private String message;
    private Integer code;
    private boolean status;


    
    public ResponseViewModel(String message, Integer code, boolean status) {
        this.message = message;
        this.code = code;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
