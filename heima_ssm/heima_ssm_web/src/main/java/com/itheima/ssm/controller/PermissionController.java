package com.itheima.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.ssm.domain.Permission;
import com.itheima.ssm.domain.Role;
import com.itheima.ssm.domain.UserInfo;
import com.itheima.ssm.service.impl.PermissionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Classname PermissionController
 * @Description TODO
 * @Date 2020/5/24 13:52
 * @Created by Leslie
 */
@Controller
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    PermissionServiceImpl permissionService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1") Integer page, @RequestParam(name="size",required = true,defaultValue = "4") Integer size) throws Exception {
        ModelAndView mav=new ModelAndView();
        List<Permission> permissions = permissionService.findAll(page,size);
        PageInfo pageInfo = new PageInfo(permissions);
        mav.addObject("pageInfo",pageInfo);
        mav.setViewName("permission-list");
        return mav;
    }
    @RequestMapping("/savePermission.do")
    public String saveRole(Permission permission) throws Exception {
        permissionService.savePermission(permission);
        return "redirect:findAll.do";

    }

}
