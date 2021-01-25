package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
//import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.example.demo.entity.User;

import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/hello")
    public String helloController(){
        //访问音频数据/tips/user_tts151953.wav

        return "hello fuyi";
    }

    @RequestMapping("/delete")
    public List<User> deleteUser(Integer id){
        /**
         *  模仿云端API，封装数据，完善其他的接口
         */
        int deleteById = userService.deleteUser(id);
        System.out.println("deleteId "+ deleteById);
        List<User> users = userService.findUser(null);
        return users;
    }

    /**
     *
     * @return
     */
    @RequestMapping("/find")
    public List<User> findUser(Integer id, String username,String password,String sex,String address){
//        EntityWrapper<User> wrapper = new EntityWrapper<>(new User());
        QueryWrapper<User> wrapper = new QueryWrapper<User>();
        System.out.println(id + " " + username + " " + password + " " + sex + " " + address);
        if(id!= null && !id.equals("")){
            wrapper.eq("id",id);
        }

        if(username!= null && !username.equals("")){
            wrapper.eq("username",username);
        }

        if(password!= null && !password.equals("")){
            wrapper.eq("password",password);
        }

        if(sex!= null && !sex.equals("")){
            wrapper.eq("sex",sex);
        }

        if(address!= null && !address.equals("")){
            wrapper.eq("address",address);
        }
        System.out.println("wrapper== "+ wrapper);

        return userService.findUser(wrapper);
    }

}
