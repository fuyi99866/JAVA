package com.fy.ssm.service.impl;

import com.fy.ssm.dao.IRoleDao;
import com.fy.ssm.domain.Permission;
import com.fy.ssm.domain.Role;
import com.fy.ssm.service.IRoleService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class RoleServiceImpl implements IRoleService {
    @Autowired
    private IRoleDao roleDao;
    @Override
    public List<Role> findAll(Integer page,Integer size) throws Exception {
        PageHelper.startPage(page,size);
        return roleDao.findAll();
    }

    @Override
    public void save(Role role) throws Exception {
        roleDao.save(role);
    }

    @Override
    public Role findById(Integer id) throws Exception {
        return roleDao.findById(id);
    }

    @Override
    public List<Permission> findOtherPermission(Integer id) throws Exception {
        return roleDao.findOtherPermission(id);
    }

    @Override
    public void addPermissionToRole(Integer[] permissionIds,Integer roleId) throws Exception {
        for(Integer permissionId:permissionIds){
            System.out.println("roleId---->"+roleId);
            System.out.println("permissionId---->"+permissionId);
            roleDao.addPermissionToRole(permissionId,roleId);
        }
    }
}
