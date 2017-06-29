package com.sung.result;

/**
 * 应用系统级别的错误码
 * <p>
 * Created by sungang on 2017/5/19.
 */
public enum GlobalErrorInfoEnum implements ErrorInfo {

    SUCCESS("200", "success"),
    NOT_FOUND("-1", "service not found");

    private String code;

    private String message;

    GlobalErrorInfoEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }
}
