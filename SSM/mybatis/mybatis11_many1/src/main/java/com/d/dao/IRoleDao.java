package com.d.dao;

import com.d.domain.Role;

import java.util.List;

public interface IRoleDao {
    /**
     * 查询所有角色
     * @return
     */
    List<Role> findAll();


}
