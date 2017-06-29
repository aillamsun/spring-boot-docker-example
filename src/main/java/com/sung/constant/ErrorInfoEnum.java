package com.sung.constant;

import com.sung.result.ErrorInfo;

/**
 * Created by sungang on 2017/5/19.
 */
public enum ErrorInfoEnum implements ErrorInfo {

    PARAMS_NOT_NULL("000001","params not null"),
    USER_NOT_FOUNT("000002"," 用户不存在"),
    USER_ID_NOT_FOUNT("000003"," 用户ID不能为空或者不存在改用户"),
    USER_ACCOUNT_NOT_NULL("000004","  用户账号不能为空");

    private String code;

    private String message;

    ErrorInfoEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode(){
        return this.code;
    }

    public String getMessage(){
        return this.message;
    }
}
