package com.mall.mapper;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mall.entity.MallUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * (MallUser)表数据库访问层
 *
 * @author makejava
 * @since 2023-02-17 16:07:35
 */
@Repository
@Mapper
public interface MallUserMapper extends BaseMapper<MallUser> {


    /**
     * 查询登录
     *
     * @param mallUsername 用户名
     * @return {@link MallUser}
     */
    MallUser queryLogin(String mallUsername);

    /**
     * 查询所有商城用户
     *
     * @param page         页面
     * @param queryWrapper 查询包装
     * @return {@link List}<{@link MallUser}>
     */

    @Select("select mu.* from mall_user mu join mall_user_role mur on mu.mall_user_id = mur.mall_user_id join mall_role mr on mur.mall_role_id = mr.mall_role_id where"
            +" mr.mall_role_name like '%Admin%' ${ew.customSqlSegment}")
    List<MallUser> queryAllMallUser(@Param("page") Page<MallUser> page,@Param(Constants.WRAPPER) QueryWrapper<MallUser> queryWrapper);


}

