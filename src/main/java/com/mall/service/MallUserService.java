package com.mall.service;

import com.mall.entity.MallRole;
import com.mall.entity.MallUser;

import java.util.List;
import java.util.Map;


/**
 * (MallUser)表服务接口
 *
 * @author makejava
 * @since 2023-02-17 16:07:37
 */
// @Service
public interface MallUserService {

    /**
     * 登录
     *
     * @param username 用户名
     * @return {@link MallUser}
     */
    MallUser login(String username);

    /**
     * 通过用户名查询角色
     *
     * @param mallUsername 商城用户名
     * @return {@link List}<{@link MallRole}>
     */
    List<MallRole> getRolesByUserName(String mallUsername);


    /**
     * 查询用户名字
     *
     * @param mallNickName 用户名
     * @return {@link MallUser}
     */
    boolean queryUserByName(String mallNickName);

    public Boolean register(MallUser mallUser);

    /**
     * 查询所有商城用户
     *
     * @param mallUser 商城用户
     * @return {@link List}<{@link MallUser}>
     */
    Map<String, Object> queryAllMallUser(String role,Integer pageNum, Integer pageSize, MallUser mallUser);
     Map<String, Object> selectAll(Integer pageNum, Integer pageSize);

}
