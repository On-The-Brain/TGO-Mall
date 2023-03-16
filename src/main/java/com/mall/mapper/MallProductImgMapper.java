package com.mall.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.mall.entity.MallProductImg;
import org.springframework.stereotype.Repository;

/**
 * (MallProductImg)表数据库访问层
 *
 * @author Mr.Z
 * @since 2023-03-15 12:58:48
 */
@Mapper
@Repository
public interface MallProductImgMapper extends BaseMapper<MallProductImg> {

/**
* 批量新增数据（MyBatis原生foreach方法）
*
* @param entities List<MallProductImg> 实例对象列表
* @return 影响行数
*/
int insertBatch(@Param("entities") List<MallProductImg> entities);

/**
* 批量新增或按主键更新数据（MyBatis原生foreach方法）
*
* @param entities List<MallProductImg> 实例对象列表
* @return 影响行数
* @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
*/
int insertOrUpdateBatch(@Param("entities") List<MallProductImg> entities);

}

