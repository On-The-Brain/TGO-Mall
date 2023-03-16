package com.mall.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mall.entity.MallPermission;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * (MallPermission)表数据库访问层
 *
 * @author makejava
 * @since 2023-02-17 16:07:38
 */
@Repository
@Mapper
public interface MallPermissionMapper extends BaseMapper<MallPermission> {

    /**
     * 通过角色id查询权限
     *
     * @param mallRoleId 角色id
     * @return {@link MallPermission}
     */
    List<MallPermission> queryByRoleId(Integer mallRoleId);


}

