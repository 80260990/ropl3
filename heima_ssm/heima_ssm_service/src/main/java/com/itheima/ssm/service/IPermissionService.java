package com.itheima.ssm.service;

import com.itheima.ssm.domain.Permission;

import java.util.List;

/**
 * @Classname IPermissionService
 * @Description TODO
 * @Date 2020/5/24 13:49
 * @Created by Leslie
 */
public interface IPermissionService {
    List<Permission> findAll(int page,int size)throws Exception;

    void savePermission(Permission permission)throws Exception;
}
