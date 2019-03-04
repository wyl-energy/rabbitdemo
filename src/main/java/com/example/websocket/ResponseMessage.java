package com.example.websocket;

/**
 * 响应消息类
 */
public class ResponseMessage {
    private Integer sionId ;
    private Integer userId;
    private Integer yaoId;
    private String message ;


    public String getMessage() {
        return message;
    }

    public Integer getSionId() {
        return sionId;
    }

    public void setSionId(Integer sionId) {
        this.sionId = sionId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getYaoId() {
        return yaoId;
    }

    public void setYaoId(Integer yaoId) {
        this.yaoId = yaoId;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
