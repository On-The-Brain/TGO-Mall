package com.mall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mall.entity.MallRole;
import com.mall.entity.MallUser;
import com.mall.mapper.MallRoleMapper;
import com.mall.mapper.MallUserMapper;
import com.mall.service.MallUserService;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

/**
 * (MallUser)表服务实现类
 *
 * @author makejava
 * @since 2023-02-17 16:07:38
 */
@Service("mallUserServiceImpl")
public class MallUserServiceImpl extends ServiceImpl<MallUserMapper, MallUser> implements MallUserService {

    // private final Logger logger = LoggerFactory.getLogger(MallUserServiceImpl.class);
    @Resource
    private MallUserMapper mallUserMapper;
    @Resource
    private MallRoleMapper mallRoleMapper;

    /**
     * 登录
     *
     * @param username 用户名
     * @return {@link MallUser}
     */
    @Override
    public MallUser login(String username) {
        return mallUserMapper.queryLogin(username);
    }


    @Override
    public List<MallRole> getRolesByUserName(String mallUsername) {
        return mallRoleMapper.getRolesByUserName(mallUsername);
    }

    /**
     * 查询用户名字
     *
     * @param mallNickName 用户名
     * @return boolean
     */
    @Override
    public boolean queryUserByName(String mallNickName) {
        boolean flag = false;
        QueryWrapper<MallUser> wrapper = new QueryWrapper<>();
        wrapper.eq("mall_nick_name", mallNickName);
        if (mallUserMapper.selectCount(wrapper) > 0) {
            flag = true;
        }
        return flag;
    }

    /**
     * 注册
     *
     * @param mallUser 用户
     * @return {@link Integer}
     */
    @Override

    public Boolean register(MallUser mallUser) {
        mallUser.setMallUserRegisterTime(new Date());
        mallUser.setMallUserState(1);
        Md5Hash md5Hash = new Md5Hash(mallUser.getMallPassword(), "mall", 1024);
        mallUser.setMallPassword(md5Hash.toString());
        int insert = mallUserMapper.insert(mallUser);
        Integer integer = mallRoleMapper.insertUserAndRole(mallUser.getMallUserId(), 5);
        return insert > 0 && integer > 0;
    }

    /**
     * 查询所有商城用户
     *
     * @param role     角色
     * @param pageNum  页面num
     * @param pageSize 页面大小
     * @param field    场
     * @return {@link Map}<{@link String}, {@link Object}>
     */
    @Override
    public Map<String, Object> queryAllMallUser(String role, Integer pageNum, Integer pageSize, String field) {
        QueryWrapper<MallUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(StringUtils.isNotBlank(field), "mall_username", field).or().like(StringUtils.isNotBlank(field), "mall_user_phone", field).or().like(StringUtils.isNotBlank(field), "mall_nick_name", field);
        queryWrapper.like(StringUtils.isNotBlank(role), "mall_role_name", role);
        Page<MallUser> page = new Page<>(pageNum, pageSize);
        List<MallUser> mallUsers = mallUserMapper.selectAllByPage(page, queryWrapper);
        List<MallUser> mallUserList = new ArrayList<>();
        mallUsers.stream().forEach(p -> {
            if (!mallUserList.contains(p)) {
                mallUserList.add(p);
            }
        });
        Map<String, Object> map = new HashMap<>();
        map.put("rows", mallUserList);
        map.put("total", page.getTotal());
        return map;
    }

    @Transactional
    @Override
    public Integer updateUserRole(Integer userId, List<Integer> list, Integer start) {
        Integer integer;
        if (start == 1) {
            integer = mallUserMapper.insertUserRole(userId, list);
        } else {
            integer = mallUserMapper.deleteUserRole(userId, list);
        }
        return integer;
    }

}
