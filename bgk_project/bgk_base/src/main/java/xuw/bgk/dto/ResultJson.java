/**
 * @(#)ResultJson.java
 * @author yubo
 * @version 1.0 2014年10月31日
 * <p/>
 * Copyright (C) 2012,2014 , PING' AN, Inc.
 */
package xuw.bgk.dto;

/**
 *
 * Purpose:
 *
 * @see
 * @since 1.1.0
 */
public class ResultJson {
    //ajax 请求服务器代码放回状态
    //成功
    public static final Integer STATUS_CODE_SUCCESS = Integer.valueOf(1);

    //未找到数据
    public static final Integer STATUS_CODE_NO_DATA = Integer.valueOf(2);
    // 数据库获取不到数据信息错误
    public static final Integer STATUS_CODE_DATA_ERROR = Integer.valueOf(20001);

    //接口未授权
    public static final Integer STATUS_CODE_NOT_AUTH = Integer.valueOf(3);
    //请求已过期
    public static final Integer STATUS_CODE_REQUEST_EXPIRE = Integer.valueOf(30001);

    //请求参数错误代码
    public static final Integer STATUS_CODE_PARAM_ERROR = Integer.valueOf(4);

    // SESSION 失效错误
    public static final Integer STATUS_CODE_SESSION_INVALID = Integer.valueOf(5);

    //失败
    public static final Integer STATUS_CODE_FAIL = Integer.valueOf(6);

    //出现异常
    public static final Integer STATUS_CODE_EXCEPTION = Integer.valueOf(99999);

    public static final String STATUS_CODE_NO_DATA_MESSAGE = "未发现相关数据";
    public static final String STATUS_CODE_PARAM_ERROR_MESSAGE = "参数错误";
    public static final String STATUS_CODE_EXCEPTION_MESSAGE = "系统错误";
    public static final String STATUS_CODE_SUCCESS_MESSAGE = "请求成功";

    private int statusCode;

    private String statusMessage;

    private Object data;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setSuccessMessage(String msg) {
        this.setStatusCodeAndMessage(STATUS_CODE_SUCCESS, msg);
    }

    public void setStatusCodeAndMessage(int statusCode, String msg) {
        this.statusCode = statusCode;
        this.statusMessage = msg;
    }

    public void setFailMessage(String msg){
        this.setStatusCodeAndMessage(STATUS_CODE_FAIL, msg);
    }


}


