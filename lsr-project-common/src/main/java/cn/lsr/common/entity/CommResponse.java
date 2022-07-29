package cn.lsr.common.entity;

/**
 * @Description: 公共的响应对象
 * @Author: lsr
 * @Date 2022年07月27日 16:10
 */
public class CommResponse<T> {
    public static final String DEFAULT_SUCCESS_CODE = "000000000000";
    public static final String DEFAULT_SUCCESS_MSG = "Success";
    public static final String DEFAULT_ERROR_CODE = "999999999999";
    public static final String DEFAULT_ERROR_MSG = "Fail";
    public static final String SUCCESS_TYPE = "01";
    public static final String ERROR_TYPE = "02";
    public static final String UNKNOWN_TYPE = "03";
    private String responseCode;
    private String responseInfo;
    private String responseTypeCode;
    private T data;

    public static CommResponse success(){
        return new CommResponse();
    }

    public static CommResponse success(Object data){
        return new CommResponse(data);
    }

    public static CommResponse error(String responseInfo){
        return new CommResponse(responseInfo);
    }

    public static CommResponse error(String responseCode,String responseInfo){
        return new CommResponse(responseCode,responseInfo);
    }

    public static CommResponse error(String responseCode,String responseTypeCode,String responseInfo){
        return new CommResponse(responseCode,responseTypeCode,responseInfo);
    }

    public static CommResponse error(Object data){
        return new CommResponse(data);
    }

    public CommResponse(String responseInfo){
        this.responseCode = DEFAULT_ERROR_CODE;
        this.responseTypeCode = ERROR_TYPE;
        this.responseInfo = responseInfo;
    }

    public CommResponse(String responseCode,String responseInfo){
        this.responseCode = responseCode;
        this.responseTypeCode = ERROR_TYPE;
        this.responseInfo = responseInfo;
    }

    public CommResponse(String responseCode,String responseTypeCode,String responseInfo){
        this.responseCode = responseCode;
        this.responseTypeCode = responseTypeCode;
        this.responseInfo = responseInfo;
    }

    public CommResponse(){
        this.responseCode = DEFAULT_SUCCESS_CODE;
        this.responseTypeCode = SUCCESS_TYPE;
        this.responseInfo = DEFAULT_SUCCESS_MSG;
    }

    public CommResponse(T data){
        this.data = data;
        this.responseTypeCode = SUCCESS_TYPE;
        this.responseCode = DEFAULT_SUCCESS_CODE;
        this.responseInfo = DEFAULT_SUCCESS_MSG;
    }


    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseInfo() {
        return responseInfo;
    }

    public void setResponseInfo(String responseInfo) {
        this.responseInfo = responseInfo;
    }

    public String getResponseTypeCode() {
        return responseTypeCode;
    }

    public void setResponseTypeCode(String responseTypeCode) {
        this.responseTypeCode = responseTypeCode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
