package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/find")
    public List<User> GetUser(Integer id, String username,String password,String sex,String address){
        System.out.println(id + " "+ username + " " + password + " " + sex + " " + address );
    /*    QueryWrapper<User> wrapper = new QueryWrapper<User>();
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
        System.out.println("wrapper== "+ wrapper);*/

        return userService.findAll(null);
    }

    @RequestMapping("/add")
    public List<User> AddUser(User user){
        int result = userService.insertUser(user);
        if(result >= 1){
            return userService.findAll(null);
        }else{
            return null;
        }
    }

    @RequestMapping("/update")
    public List<User> UpdateUser(User user){
        int result = userService.updateUser(user);
        if(result >= 1){
            return userService.findAll(null);
        }else{
            return null;
        }
    }

    @RequestMapping("/delete")
    public List<User> DeleteUser(int id){
        int result = userService.delete(id);
        if(result >= 1){
            return userService.findAll(null);
        }else{
            return null;
        }
    }
}
