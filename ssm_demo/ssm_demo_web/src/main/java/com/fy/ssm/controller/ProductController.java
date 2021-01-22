package com.fy.ssm.controller;

import com.fy.ssm.domain.Product;
import com.fy.ssm.service.IProductService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;

    /**
     * 添加产品
     * @param product
     * @return
     * @throws Exception
     */
    @RequestMapping("/save.do")
    public String save(Product product) throws Exception{
        productService.save(product);
        return "redirect:findAll.do";
    }

    /**
     * 查询所有产品
     * @return
     * @throws Exception
     */
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1") Integer page,@RequestParam(name = "size",required = true,defaultValue = "10")Integer size) throws Exception{
        ModelAndView mv = new ModelAndView();
        List<Product> ps = productService.findAll(page,size);
        for (int i = 0; i < ps.size(); i++) {
            System.out.println("----->城市："+ ps.get(i).getCityName());
            System.out.println("----->出发时间："+ ps.get(i).getDepartureTimeStr());
            System.out.println("----->状态："+ ps.get(i).getProductStatusStr());
        }
        PageInfo pageInfo = new PageInfo(ps);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("product-list");
        return mv;
    }

    @RequestMapping("/findByName.do")
    public String findByName(@RequestParam(name = "pname",required = true)String pname) throws Exception{
        System.out.println("-------pname------"+pname);
        productService.findByName(pname);
        return "redirect:findAll.do";
    }
}
