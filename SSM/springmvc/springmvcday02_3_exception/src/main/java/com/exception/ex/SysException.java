package com.exception.ex;

/**
 * 自定义异常的类
 */
public class SysException extends Exception {

    //存储提示信息
    private String message;

    public SysException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
