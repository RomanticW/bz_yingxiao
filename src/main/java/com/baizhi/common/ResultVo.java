package com.baizhi.common;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author dongHua
 * @create 2022/12/27 17:34
 * FileName: ResultVo
 */
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ResultVo {
    private Integer code;
    private String message;
    private Object data;

    public Integer getCode() {
        return code;
    }

    public ResultVo setCode(Integer code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public ResultVo setMessage(String message) {
        this.message = message;
        return this;
    }

    public Object getData() {
        return data;
    }

    public ResultVo setData(Object data) {
        this.data = data;
        return this;
    }
}
