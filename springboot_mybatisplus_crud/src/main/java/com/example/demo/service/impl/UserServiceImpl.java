package com.example.demo.service.impl;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public int insertUser(User user) {
        return userMapper.insert(user);
    }

    @Override
    public int deleteUser(Integer id) {
        return userMapper.deleteById(id);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateById(user);
    }

    @Override
    public List<User> findUser(Wrapper<User> wrapper) {
        return userMapper.selectList(wrapper);
    }

    @Override
    public User findUserById(String id) {
        return userMapper.selectById(id);
    }

    @Override
    public List<User> findSearch(Map searchMap) {
        return null;
    }
}
