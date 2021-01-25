package com.example.demo.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.example.demo.entity.User;

import java.util.List;
import java.util.Map;


public interface UserService {
    /**
     * 新增
     * @param user
     * @return
     */
    int insertUser(User user);

    /**
     * 根据id删除
     * @param id
     * @return
     */
    int deleteUser(Integer id);
    /**
     * 修改
     * @param user
     * @return
     */
    int updateUser(User user);
    /**
     * 查询所有
     * @return
     */
    List<User> findUser(Wrapper<User> wrapper);

    /**
     * 根据id查找
     * @param id
     * @return
     */
    User findUserById(String id);

    /**
     * 条件查找
     * @param searchMap
     * @return
     */
    List<User> findSearch(Map searchMap);
}
