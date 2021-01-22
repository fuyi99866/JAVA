package com.fy.ssm.dao;

import com.fy.ssm.domain.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ITravellerDao {
    @Select("select * from traveller where id in (select travellerId from order_traveller where orderId = #{id})")
    public List<Traveller> findByOrdersId(Integer id) throws Exception;
}
