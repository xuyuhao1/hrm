package com.hrm.common.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Result类，用于控制器类返回结果
 */
@Data
@NoArgsConstructor  //非空数据不显示
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Result {
    private boolean flag;  //是否成功
    private Integer code;  //返回码
    private String message;//返回信息
    private Object data;    //返回数据

    public Result(ResultCode resultCode) {
        this.code = resultCode.code;
        this.flag = resultCode.success;
        this.message = resultCode.message;
    }

    public Result(ResultCode resultCode, Object data) {
        this.code = resultCode.code;
        this.flag = resultCode.success;
        this.message = resultCode.message;
        this.data = data;
    }

    public Result(boolean flag, Integer code, String message) {
        this.flag = flag;
        this.code = code;
        this.message = message;
    }

    public Result(boolean flag, Integer code, String message, Object data) {
        this.flag = flag;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static Result SUCCESS(){
        return new Result(ResultCode.SUCCESS);
    }
    public static Result SUCCESS(Object data){
        return new Result(ResultCode.SUCCESS,data);
    }

    public static Result ERROR(){
        return new Result(ResultCode.SERVER_ERROR);
    }

    public static Result FAIL(){
        return new Result(ResultCode.FAIL);
    }

}
