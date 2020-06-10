package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Member;
import com.itheima.ssm.domain.Order;
import com.itheima.ssm.domain.Product;
import com.itheima.ssm.domain.Traveller;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @Classname IOrderDao
 * @Description TODO
 * @Date 2020/5/18 13:53
 * @Created by Leslie
 */
public interface IOrderDao {

    @Select("select * from orders ")
    @Results(id="orderMap",value = {
            @Result(column = "id",property = "id"),
            @Result(column = "orderNum",property = "orderNum"),
            @Result(column = "orderTime",property = "orderTime"),
            @Result(column = "peopleCount",property = "peopleCount"),
            @Result(column = "orderDesc",property = "orderDesc"),
            @Result(column = "payType",property = "payType"),
            @Result(column = "orderStatus",property = "orderStatus"),
            @Result(property = "product",column = "productId",javaType = Product.class,one = @One(select="com.itheima.ssm.dao.IProductDao.findById",fetchType= FetchType.EAGER))
    })
    List<Order> findAll() throws Exception;

    @Select("select * from orders where id=#{id}")
    @Results(id="orderMapAll",value = {
            @Result(column = "id",property = "id"),
            @Result(column = "orderNum",property = "orderNum"),
            @Result(column = "orderTime",property = "orderTime"),
            @Result(column = "peopleCount",property = "peopleCount"),
            @Result(column = "orderDesc",property = "orderDesc"),
            @Result(column = "payType",property = "payType"),
            @Result(column = "orderStatus",property = "orderStatus"),
            @Result(property = "product",column = "productId",javaType = Product.class,one = @One(select="com.itheima.ssm.dao.IProductDao.findById",fetchType= FetchType.EAGER)),
            @Result(property = "travellers",column = "id",javaType = java.util.List.class,many = @Many(select="com.itheima.ssm.dao.ITravellerDao.findByOrdersId",fetchType= FetchType.EAGER)),
            @Result(property = "member",column = "memberId",javaType = Member.class,one = @One(select="com.itheima.ssm.dao.IMemberDao.findById",fetchType= FetchType.EAGER))
    })
    Order findById(String orderId) throws Exception;

}
