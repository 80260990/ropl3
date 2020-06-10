package com.itheima.ssm.domain;

/**
 * @Classname Permission
 * @Description TODO
 * @Date 2020/5/20 14:16
 * @Created by Leslie
 */
public class Permission {
    private  String id;
    private String permissionName;
    private String url;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
