package com.itheima.ssm.service;

import com.itheima.ssm.domain.Product;

import java.util.List;

/**
 * @Classname IProductService
 * @Description TODO
 * @Date 2020/5/16 21:33
 * @Created by Leslie
 */
public interface IProductService {

    /**
    * @Description: 查询所有
    * @Param:
    * @return:
    * @Author: Mr.jiang
    * @Date: 2020/5/16
    */
    List<Product> findAll() throws Exception;

    /**
    * @Description: 增加product
    * @Param: product
    * @return:
    * @Author: Mr.jiang
    * @Date: 2020/5/17
    */
    void saveProduct(Product product)throws Exception;

    void deleteById(Integer productId) throws Exception;

    Product findById(Integer productId) throws Exception;

    void updateById(Product product) throws Exception;
}
