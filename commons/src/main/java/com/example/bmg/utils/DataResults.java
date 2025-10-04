package com.example.bmg.utils;

public class DataResults<T> {

    private int resultCode;  //状态码
    private String message; //消息内容
    private T data;  //响应数据

    public DataResults() {

    }

    private DataResults(int resultCode, String message) {
        this.resultCode = resultCode;
        this.message = message;
    }

    private DataResults(int resultCode, String message, T data) {
        this.resultCode = resultCode;
        this.message = message;
        this.data = data;
    }

    public static DataResults<Object> success(ResultCode resultCode){
        return new DataResults<>(resultCode.getCode(), resultCode.getMsg());
    }

    public static <T> DataResults<T> success(ResultCode resultCode, T data){
        return new DataResults<>(resultCode.getCode(), resultCode.getMsg(), data);
    }

    public static DataResults<Object> fail(ResultCode resultCode){
        return new DataResults<>(resultCode.getCode(), resultCode.getMsg());
    }

    public static <T> DataResults<T> fail(ResultCode resultCode, T data){
        return new DataResults<>(resultCode.getCode(), resultCode.getMsg(), data);
    }

    // 便捷方法
    public static <T> DataResults<T> success(T data) {
        return success(ResultCode.SUCCESS, data);
    }

    public static DataResults<Object> success() {
        return success(ResultCode.SUCCESS);
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}