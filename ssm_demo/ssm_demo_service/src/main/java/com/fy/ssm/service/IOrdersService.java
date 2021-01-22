package com.fy.ssm.service;

import com.fy.ssm.domain.Orders;

import java.util.List;

public interface IOrdersService {
    public List<Orders> findAll(int page,int size) throws Exception;

    public Orders findById(Integer id) throws Exception;
}
