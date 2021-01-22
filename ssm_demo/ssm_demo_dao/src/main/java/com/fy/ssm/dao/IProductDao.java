package com.fy.ssm.dao;

import com.fy.ssm.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IProductDao {
    @Select("select * from product")
    public List<Product> findAll() throws Exception;

    @Insert("insert into product(productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    public void save(Product product) throws Exception;

    //根据id查询产品
    @Select("select * from product where id=#{id}")
    public Product findById(Integer id) throws Exception;

    @Select("select * from product where productName like %#{pname}%")
    public void findByName(String pname) throws Exception;
}
