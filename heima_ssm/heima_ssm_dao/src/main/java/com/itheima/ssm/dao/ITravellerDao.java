package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Classname ITravellerDao
 * @Description TODO
 * @Date 2020/5/19 15:14
 * @Created by Leslie
 */
public interface ITravellerDao {
    @Select(" select * from traveller where id in (select travellerId from order_traveller where orderId =#{orderId})")
    List<Traveller> findByOrdersId(String orderId) throws  Exception;
}
