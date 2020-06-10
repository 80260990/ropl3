package com.itheima.ssm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itheima.ssm.domain.SysLog;
import com.itheima.ssm.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Classname SysLogController
 * @Description TODO
 * @Date 2020/5/26 12:09
 * @Created by Leslie
 */
@Controller
@RequestMapping("/sysLog")
public class SysLogController {
    @Autowired
    ISysLogService sysLogService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1") Integer page, @RequestParam(name="size",required = true,defaultValue = "4") Integer size){
        ModelAndView mav = new ModelAndView();
        List<SysLog> sysLogList = sysLogService.findAll(page,size);
        PageInfo pageInfo = new PageInfo(sysLogList);
        mav.addObject("pageInfo",pageInfo);
        mav.setViewName("sysLog-list");
        return mav;
    }

}
