package com.fy.ssm.service.impl;

import com.fy.ssm.dao.IPermissionDao;
import com.fy.ssm.domain.Permission;
import com.fy.ssm.service.IPermissionService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PermissionServiceImpl implements IPermissionService {
    @Autowired
    private IPermissionDao permissionDao;
    @Override
    public List<Permission> findAll(Integer page,Integer size) throws Exception {
        PageHelper.startPage(page,size);
        return permissionDao.findAll();
    }

    @Override
    public void save(Permission permission) throws Exception {
        permissionDao.save(permission);
    }

    @Override
    public void deletePermission(Integer id) throws Exception {
        permissionDao.deletePermission(id);
    }
}
