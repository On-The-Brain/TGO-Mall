package com.mall.service;


import com.mall.entity.MallRole;

import java.util.List;
import java.util.Map;

/**
 * (MallRole)表服务接口
 *
 * @author makejava
 * @since 2023-02-17 16:07:38
 */
public interface MallRoleService {

    List<MallRole> queryAllAdminRole();

    Map<String, Object> selectByListPage(Integer pageNum, Integer pageSize);

    MallRole queryByField(String field, String f);
    Map<String,Integer> createRole(MallRole mallRole, List list);
    Map<String, Integer> removeRole(Integer mallRoleId);
    Integer updateRole(Integer roleId, List<Integer> list, Integer start);
}
