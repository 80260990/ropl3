package com.itheima.ssm.service;

import com.itheima.ssm.domain.Permission;
import com.itheima.ssm.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Classname IRoleService
 * @Description TODO
 * @Date 2020/5/23 19:01
 * @Created by Leslie
 */
public interface IRoleService {

    List<Role> findRoleAll(int page,int size)throws Exception;

    Role findById(String id)throws Exception;

    void saveRole(Role role)throws Exception;

    List<Permission> findOtherPermissions(String roleId)throws Exception;

    void addPermissionToRole(String roleId, String[] permissionIds)throws Exception;
}
