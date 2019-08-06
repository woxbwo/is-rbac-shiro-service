package com.is.shiro.service.domain;

/**
 * @ClassName: PermissionMapper
 * @Description:
 * @Author: Coding_wxb
 * @Date 2019.08.07 1:54
 */
public class Permission {
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
