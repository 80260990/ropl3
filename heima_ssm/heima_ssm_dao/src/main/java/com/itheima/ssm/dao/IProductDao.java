package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Product;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @Classname IProductDao
 * @Description TODO
 * @Date 2020/5/16 21:30
 * @Created by Leslie
 */
public interface IProductDao {

    /**
    * @Description: 查询所有的产品信息
    * @Param: 
    * @return: 
    * @Author: Mr.jiang
    * @Date: 2020/5/16
    */
    @Select("select * from product")
    List<Product> findAll() throws Exception;

    @Insert("insert into product values(null,#{productNum},#{productName}," +
            "#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void saveProduct(Product product);

    @Select(" select * from product where id=#{id}")
    Product findById(Integer id);

    @Delete("delete from product where id=#{id}")
    void deleteById(Integer id);

    @Update("update product set productName=#{productName}," +
            "cityName=#{cityName},departureTime=#{departureTime}," +
            "productPrice=#{productPrice},productDesc=#{productDesc}," +
            "productStatus=#{productStatus} where id = #{id}")
    void updateById(Product product);




}
