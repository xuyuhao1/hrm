package com.hrm.common.exception;

import com.hrm.common.entity.ResultCode;

public class CommonException extends Exception{
    private ResultCode resultCode;

    public ResultCode getResultCode() {
        return resultCode;
    }

    public CommonException(ResultCode resultCode) {
        this.resultCode = resultCode;
    }
}
