package com.mall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mall.entity.MallPermission;
import com.mall.mapper.MallPermissionMapper;
import com.mall.service.MallPermissionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * (MallPermission)表服务实现类
 *
 * @author makejava
 * @since 2023-02-17 16:07:38
 */
@Service("mallPermissionService")
public class MallPermissionServiceImpl implements MallPermissionService {
    @Resource
    private MallPermissionMapper mallPermissionMapper;


    @Override
    public List<MallPermission> queryById(Integer mallPermissionId) {
        List<MallPermission> mallPermissions = mallPermissionMapper.queryByRoleId(mallPermissionId);
        return mallPermissions;
    }

    /**
     * 查询所有
     *
     * @return {@link List}<{@link MallPermission}>
     */
    @Override
    public List<MallPermission> queryAll() {
        return mallPermissionMapper.selectList(null);
    }

    /**
     * 局部修改
     *
     * @return {@link Integer}
     */
    @Transactional
    @Override
    public Integer patchPermission(MallPermission mallPermission) {
        return mallPermissionMapper.updateById(mallPermission);
    }

    @Override
    public Integer addPermission(MallPermission mallPermission) {
        return mallPermissionMapper.insert(mallPermission);
    }

    @Override
    public MallPermission queryByField(String field, String f) {
        QueryWrapper<MallPermission> queryWrapper = new QueryWrapper<>();
        if (f.equals("name")) {
            // 根据名称查询
            queryWrapper.select("mallRoleName", field);
        } else if (f.equals("describe")) {
            // 根据描述查询
            queryWrapper.select(field);
        }
        return mallPermissionMapper.selectOne(queryWrapper);
    }

    @Override
    public Page<MallPermission> queryAllLike(String field, Integer size, Integer page) {
        QueryWrapper<MallPermission> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("mall_permission_name", "%" + field + "%");
        Page<MallPermission> permissionPage = new Page<>(page, size);
        Page<MallPermission> mallPermissionPage = mallPermissionMapper.selectPage(permissionPage, queryWrapper);
        if (CollectionUtils.isEmpty(mallPermissionPage.getRecords())) {
            QueryWrapper<MallPermission> queryWrapper1 = new QueryWrapper<>();
            queryWrapper1.like("mall_permission_description", "%" + field + "%");
            Page<MallPermission> mallPermissionPage1 = mallPermissionMapper.selectPage(permissionPage, queryWrapper1);
            if (CollectionUtils.isEmpty(mallPermissionPage1.getRecords())) {
                return mallPermissionMapper.selectPage(permissionPage, null);
            } else {
                return mallPermissionPage1;
            }
        } else {
            return mallPermissionPage;
        }
    }

    @Transactional
    @Override
    public Integer deletePermission(Integer permissionId) {
        return mallPermissionMapper.deleteById(permissionId);
    }

}
