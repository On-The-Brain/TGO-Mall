package com.mall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mall.entity.MallRole;
import com.mall.entity.User;

import java.util.List;
import java.util.Map;

/**
 * (User)表服务接口
 *
 * @author Mr.Z
 * @since 2023-03-21 18:29:26
 */
public interface UserService extends IService<User> {
    Map<String, Object> ListUser(String role, Integer pageNum, Integer pageSize, String field);

    /**
     * 登录
     *
     * @param filed 提起
     * @return {@link User}
     */
    User login(String filed);

    List<MallRole> getRolesByUserName(String userName);
}

