package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Member;
import org.apache.ibatis.annotations.Select;

/**
 * @Classname IMemberDao
 * @Description TODO
 * @Date 2020/5/19 15:13
 * @Created by Leslie
 */
public interface IMemberDao {
    @Select(" select * from member where id=#{id}")
    Member findById(Integer id);
}
