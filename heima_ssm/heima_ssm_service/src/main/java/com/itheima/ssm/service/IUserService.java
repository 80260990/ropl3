package com.itheima.ssm.service;


import com.itheima.ssm.domain.Role;
import com.itheima.ssm.domain.UserInfo;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * @Classname IUserService
 * @Description TODO
 * @Date 2020/5/20 14:06
 * @Created by Leslie
 */
public interface IUserService extends UserDetailsService {

    List<UserInfo> findAll(int page,int size)throws Exception;

    void saveUser(UserInfo userInfo)throws Exception;

    UserInfo findById(String id) throws Exception;

    List<Role> findOtherRole(String userId);

    void addRoleToUser(String userId, String[] roleIds);
}
