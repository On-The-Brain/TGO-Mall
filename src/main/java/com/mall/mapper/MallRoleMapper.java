package com.mall.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mall.entity.MallRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (MallRole)表数据库访问层
 *
 * @author makejava
 * @since 2023-02-17 16:07:38
 */
@Repository
@Mapper
public interface MallRoleMapper extends BaseMapper<MallRole> {

    /**
     * 通过用户id查询角色
     *
     * @param mallUserId 商城用户id
     * @return 实例对象
     */
    MallRole queryRolesByUserId(Integer mallUserId);

    List<MallRole> queryAllRolesByUserId(Integer mallUserId);

    /**
     * 被用户名角色
     *
     * @param mallUsername 商城用户名
     * @return {@link List}<{@link MallRole}>
     */
    List<MallRole> getRolesByUserName(String mallUsername);

    /**
     * 查询所有管理角色
     *
     * @return {@link List}<{@link MallRole}>
     */
    List<MallRole> queryAllAdminRole();

    /**
     * 查询所有角色
     *
     * @return {@link List}<{@link MallRole}>
     */
    List<MallRole> queryAllRole(Page<MallRole> page);

    /**
     * 插入角色权限
     *
     * @param mallRoleId 购物中心角色id
     * @param list       列表
     * @return {@link Integer}
     */
    Integer insertRolePermission(@Param("mallRoleId") Integer mallRoleId, @Param("list") List list);

    /**
     * 删除权限,角色id
     *
     * @param mallRoleId 角色id
     * @return {@link Integer}
     */
    Integer deletePermissionByRoleId(Integer mallRoleId);


    /**
     * 根据权限和角色删除
     *
     * @param roleId 角色id
     * @param list   列表
     * @return {@link Integer}
     */
    Integer deleteByMallByRp(@Param("roleId") Integer roleId, @Param("list") List<Integer> list);

    Integer insertUserAndRole(Integer userId, Integer roleId);
}

