package com.itheima.ssm.dao;

import com.itheima.ssm.domain.SysLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Classname ISysLogDao
 * @Description TODO
 * @Date 2020/5/26 11:45
 * @Created by Leslie
 */
public interface ISysLogDao {
    @Insert("insert into syslog values(uuid(),#{visitTime},#{username},#{ip},#{url},#{executionTime},#{method})")
    void save(SysLog sysLog);

    @Select("select * from syslog ")
    List<SysLog> findAll();
}
