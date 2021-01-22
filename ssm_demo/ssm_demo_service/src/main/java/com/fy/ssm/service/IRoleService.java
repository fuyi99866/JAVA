package com.fy.ssm.service;

import com.fy.ssm.domain.Permission;
import com.fy.ssm.domain.Role;

import java.util.List;

public interface IRoleService {
    public List<Role> findAll(Integer page,Integer size) throws Exception;

    public void save(Role role) throws Exception;

    public Role findById(Integer id) throws Exception;

    public List<Permission> findOtherPermission(Integer id) throws Exception;

    public void addPermissionToRole(Integer[] permissionIds,Integer roleId) throws Exception;
}
