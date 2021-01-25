package com.fy.user.controller;

import com.fy.user.pojo.User;
import com.fy.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("{id}")
    @ResponseBody
    public User queryUserById(@PathVariable("id")Long id){
        return userService.queryUserById(id);
    }

    @GetMapping("all")
    public String toUsers(Model model){
        List<User> userList = userService.queryUserAll();
        model.addAttribute("userList",userList);
        return "userList";
    }
    @GetMapping("test")
    @ResponseBody
    public String test(){
        return "hello user!";
    }
}
