package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Classname IPermission
 * @Description TODO
 * @Date 2020/5/23 15:36
 * @Created by Leslie
 */
public interface IPermissionDao {


    @Select("select * from permission where id in (select permissionId from role_permission where roleId = #{roleId})")
    List<Permission> findPermissionById(String roleId);

    @Select("select * from permission")
    List<Permission> findAll()throws  Exception;

    @Insert("insert into permission values(uuid(),#{permissionName},#{url})")
    void savePermission(Permission permission)throws Exception;
}
