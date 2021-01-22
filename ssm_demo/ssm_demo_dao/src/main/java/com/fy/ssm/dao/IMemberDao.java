package com.fy.ssm.dao;

import com.fy.ssm.domain.Member;
import org.apache.ibatis.annotations.Select;

public interface IMemberDao {
    //根据id查询产品
    @Select("select * from member where id=#{id}")
    public Member findById(Integer id) throws Exception;
}
