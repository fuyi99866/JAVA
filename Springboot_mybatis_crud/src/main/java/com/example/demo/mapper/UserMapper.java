package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface UserMapper {
    List<User> findUserByName(String name);

    public List<User> findAll(Wrapper<User> wrapper);

    public int insertUser(User user);

    public int delete(int id);

    public int updateUser(User user);
}
