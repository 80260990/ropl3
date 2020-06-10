package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Permission;
import com.itheima.ssm.domain.Role;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @Classname IRoleDao
 * @Description TODO
 * @Date 2020/5/21 12:09
 * @Created by Leslie
 */
public interface IRoleDao {
    @Select("select * from role where id in (select roleId from users_role where userId = #{userId})")
    @Results({
            @Result(id=true,property = "id",column = "id"),
            @Result(property = "roleName" ,column = "roleName"),
            @Result(property = "roleDesc" , column = "roleDesc"),
            @Result(property = "permissions" ,column = "id",javaType = java.util.List.class,many = @Many(select="com.itheima.ssm.dao.IPermissionDao.findPermissionById",fetchType= FetchType.EAGER))
    })
    List<Role> findRoleByUserId(String userId);

    @Select("select * from role")
    List<Role> findRoleAll()throws Exception;

    @Select("select * from role where id=#{id}")
    Role findById(String id)throws Exception;

    @Insert("insert into role values(uuid(),#{roleName},#{roleDesc})")
    void saveRole(Role role);

    @Select("select * from permission where id not in (select permissionId from role_permission where roleId = #{roleId})")
    List<Permission> findOtherPermissions(String roleId);


    @Insert("insert into role_permission(roleId,permissionId) values(#{roleId},#{permissionId})")
    void addPermissionToRole(@Param("roleId") String roleId,@Param("permissionId") String permissionId);
}
