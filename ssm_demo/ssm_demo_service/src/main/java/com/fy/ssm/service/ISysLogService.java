package com.fy.ssm.service;

import com.fy.ssm.domain.SysLog;

import java.util.List;

public interface ISysLogService {
    public List<SysLog> findAll(Integer page,Integer size) throws Exception;

    public void save(SysLog sysLog) throws Exception;
}
