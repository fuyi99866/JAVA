package com.fy.ssm.service;

import com.fy.ssm.domain.Permission;

import java.util.List;

public interface IPermissionService {
    public List<Permission> findAll(Integer page,Integer size) throws Exception;

    public void save(Permission permission) throws Exception;

    public void deletePermission(Integer id) throws Exception;
}
