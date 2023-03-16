package com.mall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mall.entity.MallRole;
import com.mall.mapper.MallRoleMapper;
import com.mall.service.MallRoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * (MallRole)表服务实现类
 *
 * @author makejava
 * @since 2023-02-17 16:07:38
 */
@Service("mallRoleService")
public class MallRoleServiceImpl implements MallRoleService {
    @Resource
    private MallRoleMapper mallRoleMapper;

    /**
     * 查询所有管理员角色
     *
     * @return {@link List}<{@link MallRole}>
     */
    @Override
    public List<MallRole> queryAllAdminRole() {
        return mallRoleMapper.queryAllAdminRole();
    }

    @Override
    public Map<String, Object> selectByListPage(Integer pageNum, Integer pageSize) {
        Page<MallRole> page = new Page<>(pageNum, pageSize);
        List<MallRole> mallRoles = mallRoleMapper.queryAllRole(page);
        // Page<MallRole> page1 = mallRoleMapper.selectPage(page, null);
        Map<String, Object> map = new HashMap<>();
        map.put("rows", mallRoles);
        map.put("total", page.getTotal());
        return map;
    }

    @Override
    public MallRole queryByField(String field, String f) {
        QueryWrapper<MallRole> userQueryWrapper = new QueryWrapper<>();
        if (f.equals("name")) {
            // 根据名称查询
            userQueryWrapper.select("mallRoleName", field);
        } else if (f.equals("describe")) {
            // 根据描述查询
            userQueryWrapper.select("mallRoleDescription", field);
        }
        return mallRoleMapper.selectOne(userQueryWrapper);
    }

    /**
     * 创建角色
     *
     * @param mallRole 购物中心角色
     * @param list     列表
     * @return {@link Map}<{@link String}, {@link Integer}>
     */
    @Transactional
    @Override
    public Map<String, Integer> createRole(MallRole mallRole, List list) {
        // int insert = mallRoleMapper.insertUseGeneratedKeys(mallRole);
        int insert = mallRoleMapper.insert(mallRole);
        Integer integer = mallRoleMapper.insertRolePermission(mallRole.getMallRoleId(), list);
        Map<String, Integer> map = new HashMap<>();
        map.put("RoleCount", insert);
        map.put("RolePermissionCount", integer);
        return map;
    }

    /**
     * 删除角色
     * 删除角色,并删除与之对应的权限
     *
     * @param mallRoleId 购物中心角色id
     * @return {@link Map}<{@link String}, {@link Integer}>
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Map<String, Integer> removeRole(Integer mallRoleId) {
        int roleCount = mallRoleMapper.deleteById(mallRoleId);
        Integer rolePermissionCount = mallRoleMapper.deletePermissionByRoleId(mallRoleId);
        Map<String, Integer> map = new HashMap<>();
        map.put("roleCount", roleCount);
        map.put("rolePermissionCount", rolePermissionCount);
        return map;
    }

    @Transactional
    @Override
    public Integer updateRole(Integer roleId, List<Integer> list, Integer start) {
        Integer integer;
        if (start == 1) {
            integer = mallRoleMapper.insertRolePermission(roleId, list);
        } else {
            integer = mallRoleMapper.deleteByMallByRp(roleId, list);
        }
        return integer;
    }
}
