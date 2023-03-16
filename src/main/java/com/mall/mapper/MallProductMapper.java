package com.mall.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mall.entity.MallProduct;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (MallProduct)表数据库访问层
 *
 * @author Mr.Z
 * @since 2023-03-15 12:52:29
 */
@Mapper
@Repository
public interface MallProductMapper extends BaseMapper<MallProduct> {


    // @Results({
    //         @Result(column = "id", property = "id"),
    //         @Result(column = "id", property = "users",
    //                 many = @Many(select = "org.spring.springboot.mapper.UserMapper.selectByAreaId"))
    // })
    List<MallProduct> selectProduct(@Param(Constants.WRAPPER) QueryWrapper<MallProduct> wrapper);


    List<MallProduct> selectProduct(Page<MallProduct> page, @Param(Constants.WRAPPER) QueryWrapper<MallProduct> wrapper);


    MallProduct selectProductOne(@Param(Constants.WRAPPER) QueryWrapper<MallProduct> wrapper);


}

