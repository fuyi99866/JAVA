package com.fy.springboot.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController//等价于@ResponseBody ＋ @Controller，返回类型为JSON\XML等
@RequestMapping("hello2")
public class Hello2Controller {
    @GetMapping("show")
    public String test(){
        return "hello springboot 2";
    }
}
