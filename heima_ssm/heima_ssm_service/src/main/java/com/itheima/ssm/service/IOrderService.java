package com.itheima.ssm.service;

import com.itheima.ssm.domain.Order;
import com.itheima.ssm.domain.Product;

import java.util.List;

/**
 * @Classname IOrderService
 * @Description TODO
 * @Date 2020/5/18 14:12
 * @Created by Leslie
 */
public interface IOrderService {


    List<Order> findAll(int page,int size) throws Exception;

    Order findById(String orderId) throws Exception;
}
