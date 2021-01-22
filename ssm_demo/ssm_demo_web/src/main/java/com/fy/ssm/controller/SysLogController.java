package com.fy.ssm.controller;

import com.fy.ssm.domain.SysLog;
import com.fy.ssm.service.ISysLogService;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Many;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/sysLog")
public class SysLogController {
    @Autowired
    private ISysLogService sysLogService;

    @RequestMapping("/findAll.do")
    public ModelAndView find(@RequestParam(name = "page" ,required = true,defaultValue = "1")Integer page,@RequestParam(name="size",required = true,defaultValue = "10")Integer size) throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        List<SysLog> sysLogs = sysLogService.findAll(page,size);
        PageInfo pageInfo = new PageInfo(sysLogs);
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("syslog-list");
        return modelAndView;
    }
}
