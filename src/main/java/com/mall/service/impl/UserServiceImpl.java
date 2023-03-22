package com.mall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mall.entity.MallRole;
import com.mall.entity.User;
import com.mall.mapper.MallRoleMapper;
import com.mall.mapper.UserMapper;
import com.mall.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (User)表服务实现类
 *
 * @author Mr.Z
 * @since 2023-03-21 18:29:26
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private MallRoleMapper mallRoleMapper;

    public Map<String, Object> ListUser(String role, Integer pageNum, Integer pageSize, String field) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(StringUtils.isNotBlank(field), "user_name", field).or().like(StringUtils.isNotBlank(field), "user_realname", field).or().like(StringUtils.isNotBlank(field), "user_nickname", field);
        queryWrapper.like(StringUtils.isNotBlank(role), "mall_role_name", role);
        Page<User> page = new Page<>(pageNum, pageSize);
        List<User> users = userMapper.selectAllByPage(page, queryWrapper);
        List<User> mallUserList = new ArrayList<>();
        users.forEach(p -> {
            if (!mallUserList.contains(p)) {
                mallUserList.add(p);
            }
        });
        Map<String, Object> map = new HashMap<>();
        map.put("rows", mallUserList);
        map.put("total", page.getTotal());
        return map;
    }

    /**
     * 登录
     *
     * @param field 字段
     * @return {@link User}
     */
    @Override
    public User login(String field) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper
                .eq(org.springframework.util.StringUtils.hasText(field)
                        , User::getUserName
                        , field);
        return userMapper.queryLogin(queryWrapper);
    }
    public List<MallRole> getRolesByUserName(String userName){
        return mallRoleMapper.getRolesByUserName(userName);
    }
}

