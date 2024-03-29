package com.my.shiro.domain;

import java.io.Serializable;

/**
 * 权限
 */
public class Permission implements Serializable{


    private static final long serialVersionUID = 6522484739519798548L;
    private int id;

    private String name;

    private String url;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
