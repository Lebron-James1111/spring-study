package com.yang.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统日志实体类
 * @author: CY.Ma
 * @date: 2023/7/5 22:13
 * @Description:
 * @doc:
 */
public class SystemLog implements Serializable {
    private static final long serialVersionUID = 4711177101283513359L;

    private String id;

    private String method;

    private String request;

    private String response;

    private Date time;

    private String remoteIp;

    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getRemoteIp() {
        return remoteIp;
    }

    public void setRemoteIp(String remoteIp) {
        this.remoteIp = remoteIp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
