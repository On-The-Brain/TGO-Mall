package com.mall.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mall.entity.MallPermission;

import java.util.List;

/**
 * (MallPermission)表服务接口
 *
 * @author makejava
 * @since 2023-02-17 16:07:38
 */
public interface MallPermissionService {

    /**
     * 通过ID查询单条数据
     *
     * @param mallPermissionId 主键
     * @return 实例对象
     */
    List<MallPermission> queryById(Integer mallPermissionId);

    /**
     * 查询所有
     *
     * @return {@link List}<{@link MallPermission}>
     */
    List<MallPermission> queryAll();

    /**
     * 局部修改
     *
     * @return {@link Integer}
     */
    Integer patchPermission(MallPermission mallPermission);

    Integer addPermission(MallPermission mallPermission);

    MallPermission queryByField(String field, String f);

    /**
     * 模糊查询所有
     *
     * @param field 场
     * @return {@link List}<{@link MallPermission}>
     */
    Page<MallPermission> queryAllLike(String field , Integer size, Integer page);

    Integer deletePermission(Integer permissionId);

}
