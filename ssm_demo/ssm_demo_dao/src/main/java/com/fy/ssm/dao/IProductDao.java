package com.fy.ssm.dao;

import com.fy.ssm.domain.Product;

import java.util.List;

public interface IProductDao {
    public List<Product> findAll() throws Exception;
}
