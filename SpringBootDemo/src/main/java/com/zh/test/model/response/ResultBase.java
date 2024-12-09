package com.zh.test.model.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.zh.test.constant.ResultCode;
import io.swagger.annotations.ApiModelProperty;

import java.util.HashMap;
import java.util.Map;

public class ResultBase {

    @ApiModelProperty(value = "返回码")
    private Integer code;

    @ApiModelProperty(value = "返回消息")
    private String message;

    @ApiModelProperty(value = "返回数据")
    private Map<String, Object> data = new HashMap<String, Object>();

    private ResultBase(){}

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public static ResultBase ok(String msg){
        ResultBase r = new ResultBase();
        r.setCode(ResultCode.SUCCESS);
        r.setMessage(msg);
        return r;
    }
    public static ResultBase ok(String msg,Map<String, Object> data){
        ResultBase r = new ResultBase();
        r.setCode(ResultCode.SUCCESS);
        r.setMessage(msg);
        r.setData(data);
        return r;
    }
    public static ResultBase error(String msg){
        ResultBase r = new ResultBase();
        r.setCode(ResultCode.ERROR);
        r.setMessage(msg);
        return r;
    }

    public ResultBase message(String message){
        this.setMessage(message);
        return this;
    }

    public ResultBase code(Integer code){
        this.setCode(code);
        return this;
    }

    public ResultBase data(String key, Object value){
        this.data.put(key, value);
        return this;
    }

    public ResultBase data(Map<String, Object> map){
        this.setData(map);
        return this;
    }
}
