package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Role;
import com.itheima.ssm.domain.UserInfo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @Classname IUserDao
 * @Description TODO
 * @Date 2020/5/20 14:08
 * @Created by Leslie
 */
public interface IUserDao {
    @Select("select * from users where username=#{username}")
    @Results({
            @Result( id=true,property = "id", column = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "email", property = "email"),
            @Result(column = "password", property = "password"),
            @Result(column = "phoneNum", property = "phoneNum"),
            @Result(column = "status", property = "status"),
            @Result(column = "id", property = "roles", javaType = java.util.List.class, many = @Many(select = "com.itheima.ssm.dao.IRoleDao.findRoleByUserId",fetchType= FetchType.EAGER))
    })
    UserInfo findByUsername(String username) throws Exception;

    @Select("select* from users")
    List<UserInfo> findAll() throws Exception;

    @Insert("insert into users(id,email,username,password,phoneNum,status) values(uuid(),#{email},#{username},#{password},#{phoneNum},#{status})")
    void saveUser(UserInfo userInfo)throws Exception;

    @Select("select * from users where id= #{id}")
    @Results({
            @Result( property = "id", column = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "email", property = "email"),
            @Result(column = "password", property = "password"),
            @Result(column = "phoneNum", property = "phoneNum"),
            @Result(column = "status", property = "status"),
            @Result(column = "id", property = "roles", javaType = java.util.List.class, many = @Many(select = "com.itheima.ssm.dao.IRoleDao.findRoleByUserId",fetchType= FetchType.EAGER))
    })
    UserInfo findById(String id) throws Exception;

    @Select("select * from role where id not in (select roleId from users_role where userId = #{userId})")
    List<Role> findOtherRoles(String userId);

    @Insert("insert into users_role(userId,roleId) values(#{userId},#{roleId})")
    void addRoleToUser(@Param("userId") String userId,@Param("roleId") String roleId);
}
