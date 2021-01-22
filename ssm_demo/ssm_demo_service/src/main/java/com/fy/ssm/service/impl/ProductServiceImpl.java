package com.fy.ssm.service.impl;

import com.fy.ssm.dao.IProductDao;
import com.fy.ssm.domain.Product;
import com.fy.ssm.service.IProductService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional//事务：抛出异常之后，事务会自动回滚，数据不会插入到数据库
public class ProductServiceImpl implements IProductService {
    @Autowired
    private IProductDao productDao;
    @Override
    public List<Product> findAll(int page,int size) throws Exception {
        PageHelper.startPage(page,size);
        return productDao.findAll();
    }

    @Override
    public void save(Product product) throws Exception {
         productDao.save(product);
    }

    @Override
    public void findByName(String pname) throws Exception {
        productDao.findByName(pname);
    }
}
