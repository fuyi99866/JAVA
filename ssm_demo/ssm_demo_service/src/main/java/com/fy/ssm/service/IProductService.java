package com.fy.ssm.service;

import com.fy.ssm.domain.Product;

import java.util.List;

public interface IProductService {
    public List<Product> findAll(int page,int size) throws Exception;
    public void save(Product product) throws Exception;

    public void findByName(String pname) throws Exception;
}
