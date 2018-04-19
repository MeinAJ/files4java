package com.aj.service.model;

/**
 * this is a class 4 jwt
 *
 * @author Administrator
 * @create 2018-02-22 22:36
 */

public class MSub {

    //id
    private Long id;

    //userName
    private String userName;

    //agent
    private String agent;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }
}
