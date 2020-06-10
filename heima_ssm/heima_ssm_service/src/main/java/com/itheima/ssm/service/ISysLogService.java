package com.itheima.ssm.service;

import com.itheima.ssm.domain.SysLog;

import java.util.List;

/**
 * @Classname ISysLogService
 * @Description TODO
 * @Date 2020/5/26 11:43
 * @Created by Leslie
 */
public interface ISysLogService {
        void save(SysLog sysLog);

        List<SysLog> findAll(Integer page, Integer size);
}
