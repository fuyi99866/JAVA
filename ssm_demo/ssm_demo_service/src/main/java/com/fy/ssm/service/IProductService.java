package com.fy.ssm.service;

import com.fy.ssm.domain.Product;

import java.util.List;

public interface IProductService {
    public List<Product> findAll() throws Exception;
}
