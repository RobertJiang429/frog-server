package com.frog.utils;

/**
 * 定义接口数据返回模板
 * @author Robert.Jiang
 * @date 2019年5月21日 下午5:02:41
 */
public class UnifiedResponse<E> {
    private int status;
    private E dataObj;
    private String error;

    public UnifiedResponse(){}

    public UnifiedResponse(int status, E dataObj, String error){
        this.status = status;
        this.dataObj = dataObj;
        this.error = error;
    }

    public int getResponseStatus() {
        return status;
    }

    public void setResponseStatus(int status) {
        this.status = status;
    }

    public E getResponseData() {
        return dataObj;
    }

    public void setResponseData(E dataObj) {
        this.dataObj = dataObj;
    }

    public String getResponseMessage() {
        return error;
    }

    public void setResponseMessage(String error) {
        this.error = error;
    }
}
