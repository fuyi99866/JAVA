package com.fy.ssm.controller;

import com.fy.ssm.domain.Role;
import com.fy.ssm.domain.UserInfo;
import com.fy.ssm.service.IUserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

    /**
     * 查询所有用户
     * @return
     * @throws Exception
     */
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1")Integer page,@RequestParam(name = "size",required = true,defaultValue = "10")Integer size) throws Exception{
        List<UserInfo> userList = userService.findAll(page,size);
        ModelAndView modelAndView = new ModelAndView();
        PageInfo pageInfo = new PageInfo(userList);
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("user-list");
        return modelAndView;
    }

    /**
     * 获取选中用户的详细信息
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id",required = true)Integer id)throws Exception{
       ModelAndView modelAndView = new ModelAndView();
       UserInfo userInfo = userService.findById(id);
       modelAndView.addObject("user",userInfo);
       modelAndView.setViewName("user-show");
       return modelAndView;
    }

    /**
     * 添加用户信息
     * @param userInfo
     * @return
     * @throws Exception
     */
    @RequestMapping("/save.do")
    @Secured("ROLE_ADMIN")//设置权限，只有角色为ADMIN的用户才能调用此方法
    public String save(UserInfo userInfo) throws Exception{
        userService.save(userInfo);
        return "redirect:findAll.do";
    }

    /**
     * 查询可以添加的角色
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping("/findUserByIdAndAllRole.do")
    public ModelAndView findUserByIdAndAllRole(@RequestParam(name = "id",required = true) Integer id) throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        UserInfo userInfo = userService.findById(id);
        List<Role> roleList = userService.findOtherRole(id);
        modelAndView.addObject("user",userInfo);
        modelAndView.addObject("roleList",roleList);
        modelAndView.setViewName("user-role-add");
        return modelAndView;
    }

    @RequestMapping("/addRoleToUser.do")
    public String addRoleToUser(@RequestParam(name = "userId",required = true) String userId,@RequestParam(name = "ids",required = true)String[] roleIds) throws Exception {
        userService.addRoleToUser(userId,roleIds);
        return "redirect:findAll.do";
    }
}
