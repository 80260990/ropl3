package com.itheima.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.ssm.domain.Permission;
import com.itheima.ssm.domain.Role;
import com.itheima.ssm.domain.UserInfo;
import com.itheima.ssm.service.impl.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Classname RoleController
 * @Description TODO
 * @Date 2020/5/23 19:04
 * @Created by Leslie
 */
@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleServiceImpl roleService;
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1") Integer page, @RequestParam(name="size",required = true,defaultValue = "4") Integer size) throws Exception {
        ModelAndView mav=new ModelAndView();
        List<Role> roleList = roleService.findRoleAll(page,size);
        PageInfo pageInfo = new PageInfo(roleList);
        mav.addObject("pageInfo",pageInfo);
        mav.setViewName("role-list");
        return mav;
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(value="id",required = true)String id)throws Exception{
        ModelAndView mav=new ModelAndView();
        Role role = roleService.findById(id);
        mav.addObject("role",role);
        mav.setViewName("role-add");
        return mav;
    }

    @RequestMapping("/saveRole.do")
    public String saveRole(Role role) throws Exception {
        roleService.saveRole(role);
        return "redirect:findAll.do";

    }
    @RequestMapping("/findRoleByIdAndAllPermission.do")
    public ModelAndView findRoleByIdAndAllPermission(@RequestParam(name = "id",required = true) String roleId) throws Exception {
        ModelAndView mav = new ModelAndView();
        //1、根据用户id查询用户
        Role role =roleService.findById(roleId);
        //2.根据用户的id查询可以添加的角色
        List<Permission> otherPermissions =  roleService.findOtherPermissions(roleId);
        mav.addObject("role",role);
        mav.addObject("permissionList",otherPermissions);
        mav.setViewName("role-permission-add");
        return mav;
    }

    @RequestMapping("/addPermissionToRole")
    public String addPermissionToRole(@RequestParam(name = "roleId" ,required = true) String roleId,@RequestParam(name = "ids",required = true) String[] permissionIds) throws Exception {
        roleService.addPermissionToRole(roleId,permissionIds);
        return "redirect:findAll.do";
    }


}
