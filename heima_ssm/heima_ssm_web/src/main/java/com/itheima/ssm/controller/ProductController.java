package com.itheima.ssm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itheima.ssm.domain.Product;
import com.itheima.ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;

/**
 * @Classname ProductController
 * @Description TODO
 * @Date 2020/5/16 23:10
 * @Created by Leslie
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @RequestMapping("/findAll.do")
    @RolesAllowed("ADMIN")          //只有ADMIN这样的角色才能访问
    public ModelAndView findAll() throws Exception{
        System.out.println("product/findAll.do");
        ModelAndView mv = new ModelAndView();
        List<Product> ps= productService.findAll();
        for (Product p: ps) {
            System.out.println(p.toString());
        }
        PageInfo pageInfo = new PageInfo(ps);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("product-list1");
        return mv;
    }

    @RequestMapping("/saveProduct.do")
    public String saveProduct(Product product) throws Exception {
        productService.saveProduct(product);
        return "redirect:findAll.do";
    }

    @RequestMapping("find2UpdateById.do")
    public ModelAndView find2UpdateById(@RequestParam(value = "id",required = true) Integer productId) throws Exception{
        ModelAndView mav  = new ModelAndView();
        Product product = productService.findById(productId);
        mav.addObject("product",product);
        mav.setViewName("product-update");
        return mav;
    }

    @RequestMapping("updateById.do")
    public String updateById(Product product) throws Exception {
        productService.updateById(product);
        return "redirect:findAll.do";
    }
    @RequestMapping("deleteById.do")
    public String deleteById(@RequestParam(value = "id",required = true) Integer productId) throws Exception {
        productService.deleteById(productId);
        return "redirect:findAll.do";
    }

}
