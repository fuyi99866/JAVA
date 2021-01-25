package com.example.demo.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public List<User> findByName(String name){
        return userMapper.findUserByName(name);
    }

    public List<User> findAll(Wrapper<User> wrapper){
        return userMapper.findAll(wrapper);
    }

    public int insertUser(User user){
        return userMapper.insertUser(user);
    }

    public int delete(int id){
        return userMapper.delete(id);
    }

    public int updateUser(User user){
        return userMapper.updateUser(user);
    }

}
