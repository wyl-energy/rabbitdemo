package com.example.websocket;

import java.io.Serializable;

/***
 * 请求消息类
 */

public class RequestMessage implements Serializable{

    private Integer sionId ;
    private Integer userId;
    private Integer yaoId;
    private String message;

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
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
}
