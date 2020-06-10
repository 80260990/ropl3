package com.itheima.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.ssm.domain.Order;
import com.itheima.ssm.domain.Product;
import com.itheima.ssm.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Classname OrderController
 * @Description TODO
 * @Date 2020/5/18 13:45
 * @Created by Leslie
 */
@Controller
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    IOrderService orderService;
/*
    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Order> os= orderService.findAll(page,size);
        for (Order o: os) {
            System.out.println(o.toString());
        }
        mv.addObject("os",os);
        mv.setViewName("order-list");
        return mv;
    }*/

    @RequestMapping("/findAll.do")
    @Secured("ROLE_ADMIN")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1") Integer page,@RequestParam(name="size",required = true,defaultValue = "4") Integer size) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Order> os= orderService.findAll(page,size);
        for (Order o: os) {
            System.out.println(o.toString());
        }
//        PageInfo就是一个分页Bean
        PageInfo pageInfo = new PageInfo(os);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("order-list");
        return mv;
    }



    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(value = "id",required = true) String orderId) throws Exception {
        ModelAndView mav = new ModelAndView();
        Order order = orderService.findById(orderId);
        mav.addObject("orders",order);
        mav.setViewName("orders-show");
        return mav;
    }



}
