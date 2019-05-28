package com.frog.utils;

/**
 * 定义接口错误码信息
 * @author Robert.Jiang
 * @date 2019年5月21日 下午5:04:25
 */
public enum UnifiedCode {
    OK(200, "OK"), BUS_ERR(500, "Business Error"), SYS_ERR(600, "System Error");

    private int code;
    private String desc;
    UnifiedCode(int code, String desc){
        this.code = code;
        this.desc = desc;
    }

    public int getCode(){
        return code;
    }

    public String getDesc(){
        return desc;
    }
}
