package com.mall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mall.entity.MallRole;
import com.mall.entity.MallUser;
import com.mall.mapper.MallRoleMapper;
import com.mall.mapper.MallUserMapper;
import com.mall.service.MallUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (MallUser)表服务实现类
 *
 * @author makejava
 * @since 2023-02-17 16:07:38
 */
@Service("mallUserServiceImpl")
public class MallUserServiceImpl implements MallUserService {

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
        int insert = mallUserMapper.insert(mallUser);
        Integer integer = mallRoleMapper.insertUserAndRole(insert, 5);
        return insert > 0 && integer > 0;
    }

    /**
     * 查询所有商城用户
     *
     * @param mallUser 商城用户
     * @return {@link List}<{@link MallUser}>
     */
    @Override
    public Map<String, Object> queryAllMallUser(String role, Integer pageNum, Integer pageSize, MallUser mallUser) {
        Page<MallUser> page = new Page<>(pageNum, pageSize);
        QueryWrapper<MallUser> wrapper = new QueryWrapper<>();
        if (mallUser != null) {
            if (mallUser.getMallNickName() != null) {
                wrapper.like(StringUtils.isNotBlank(mallUser.getMallNickName()), "mall_username", mallUser.getMallNickName())
                        .or().like(StringUtils.isNotBlank(mallUser.getMallNickName()), "mall_nick_name", mallUser.getMallNickName());
            }
        }
        List<MallUser> mallUsers = mallUserMapper.queryAllMallUser(page, wrapper);
        Map<String, Object> map = new HashMap<>();
        map.put("rows", mallUsers);
        map.put("total", page.getTotal());
        return map;
    }

    public Map<String, Object> selectAll(Integer pageNum, Integer pageSize) {
        Page<MallUser> page = new Page<>(pageNum, pageSize);
        Page<MallUser> mallUserPage = mallUserMapper.selectPage(page, null);
        mallUserPage.getRecords().forEach(s -> {
            s.setMallRoleList(mallRoleMapper.queryAllRolesByUserId(s.getMallUserId()));
        });
        Map<String, Object> map = new HashMap<>();
        map.put("rows", mallUserPage.getRecords());
        map.put("total", page.getTotal());
        return map;
    }

}
