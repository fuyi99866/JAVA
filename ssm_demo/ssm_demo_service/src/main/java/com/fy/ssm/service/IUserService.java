package com.fy.ssm.service;

import com.fy.ssm.domain.Role;
import com.fy.ssm.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService {
    List<UserInfo> findAll(Integer page,Integer size) throws Exception;

    void save(UserInfo userInfo) throws Exception;

    UserInfo findById(Integer id) throws Exception;

    List<Role> findOtherRole(Integer id) throws Exception;

    void addRoleToUser(String userId, String[] roleIds) throws Exception;
}
