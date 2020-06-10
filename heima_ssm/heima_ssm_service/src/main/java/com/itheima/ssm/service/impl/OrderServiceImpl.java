package com.itheima.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.itheima.ssm.dao.IOrderDao;
import com.itheima.ssm.domain.Order;
import com.itheima.ssm.domain.Product;
import com.itheima.ssm.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Classname OrderServiceImpl
 * @Description TODO
 * @Date 2020/5/18 14:13
 * @Created by Leslie
 */
@Service
@Transactional
public class OrderServiceImpl implements IOrderService {
    @Autowired
    private IOrderDao orderDao;


    public List<Order> findAll(int page,int size) throws Exception {
        //参数pageNum是页码值，参数pageSize代表是每页显示条数
        PageHelper.startPage(page,size);        //必须写在return orderDao.findAll()前面
        return orderDao.findAll();
    }




    public Order findById(String orderId)throws Exception {
        return orderDao.findById(orderId);
    }
}
