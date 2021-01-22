package com.fy.ssm.controller;

import com.fy.ssm.domain.Orders;
import com.fy.ssm.service.IOrdersService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private IOrdersService ordersService;

    @RequestMapping("/findAll.do")
/*    public ModelAndView findAll() throws Exception{
        List<Orders> ordersList = ordersService.findAll();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("orders-list");
        mv.addObject("ordersList",ordersList);
        return mv;
    }*/
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1")Integer page,@RequestParam(name ="size",required = true,defaultValue = "10")Integer size) throws Exception{
        List<Orders> ordersList = ordersService.findAll(page,size);
        ModelAndView mv = new ModelAndView();
        //PageInfo就是一个分页bean
        PageInfo pageInfo = new PageInfo(ordersList);
        mv.setViewName("orders-page-list");
        mv.addObject("pageInfo",pageInfo);
        return mv;
    }

    @RequestMapping("findById.do")
    public ModelAndView findById(@RequestParam(name = "id",required = true)Integer id) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        Orders orders = ordersService.findById(id);
        modelAndView.addObject("orders",orders);
        modelAndView.setViewName("orders-show");
        return modelAndView;
    }
}
