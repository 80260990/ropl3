package com.itheima.ssm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itheima.ssm.domain.Role;
import com.itheima.ssm.domain.UserInfo;
import com.itheima.ssm.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resources;
import java.util.List;

/**
 * @Classname UserController
 * @Description TODO
 * @Date 2020/5/22 15:38
 * @Created by Leslie
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @RequestMapping("/findAll.do")
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ModelAndView userFindAll(ModelAndView mav, @RequestParam(name = "page",required = true,defaultValue = "1" )Integer page,@RequestParam(name = "size",required = true,defaultValue = "4")Integer size) throws Exception {
        List<UserInfo> userInfos=userService.findAll(page,size);
        PageInfo pageInfo = new PageInfo(userInfos);
        mav.addObject("pageInfo",pageInfo);
        mav.setViewName("users-list");
        return mav;
    }


    @RequestMapping("/saveUser.do")
//    @PreAuthorize("authentication.principal.username=='tom'")            //只有tom才能进入这个方法
    public String save(UserInfo userInfo) throws Exception {
        userService.saveUser(userInfo);
        return "redirect:findAll.do";
    }

    @RequestMapping("/userFindById.do")
    public ModelAndView userFindById(@RequestParam(value = "id",required = true)String id) throws Exception {
        ModelAndView mav = new ModelAndView();
        UserInfo userInfo = userService.findById(id);
        mav.addObject("user",userInfo);
        mav.setViewName("users-show1");
        return mav;
    }

    @RequestMapping("/findUserByIdAndAllRole.do")
    public ModelAndView findUserByIdAndAllRole(@RequestParam(name = "id",required = true) String userId) throws Exception {
        ModelAndView mav = new ModelAndView();
        //1、根据用户id查询用户
        UserInfo userInfo = userService.findById(userId);
        //2.根据用户的id查询可以添加的角色
       List<Role> otherRoles =  userService.findOtherRole(userId);
        mav.addObject("user",userInfo);
        mav.addObject("roleList",otherRoles);
        mav.setViewName("users-role-add");
        return mav;
    }

    //给用户添加角色
    @RequestMapping("/addRoleToUser.do")
    public String addRoleToUser(@RequestParam(name = "userId" ,required = true) String userId,@RequestParam(name = "ids",required = true) String[] roleIds){
        userService.addRoleToUser(userId,roleIds);
        return "redirect:findAll.do";
    }


}
