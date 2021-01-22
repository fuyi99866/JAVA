package com.fy.ssm.dao;

import com.fy.ssm.domain.Permission;
import com.fy.ssm.domain.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IRoleDao {
    /**
     * 根据用户ID，查询角色ID
     * @param userId
     * @return
     * @throws Exception
     */
    @Select("select * from role where id in (select roleId from users_role where userId = #{userId})")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "roleName",column = "roleName"),
            @Result(property = "roleDesc",column = "roleDesc"),
            @Result(property = "permissions",column = "id",javaType = List.class,many = @Many(select = "com.fy.ssm.dao.IPermissionDao.findPermissionByRoleId"))
    })
    public List<Role> findRoleByUserId(String userId) throws Exception;

    /**
     * 查询所有的角色
     * @return
     * @throws Exception
     */
    @Select("select * from role")
    public List<Role> findAll() throws Exception;

    @Insert("insert into role(roleName,roleDesc) values(#{roleName},#{roleDesc})")
    public void save(Role role) throws Exception;

    @Select("select * from role where id=#{id}")
    public Role findById(Integer id) throws Exception;

    @Select("select * from permission where id not in (select permissionId from role_permission where roleId=#{id})")
    public List<Permission> findOtherPermission(Integer id);

    @Insert("insert into role_permission (permissionId,roleId) values(#{permissionId},#{roleId})")
    public void addPermissionToRole(@Param("permissionId") Integer permissionId,@Param("roleId") Integer roleId) throws Exception;
}
