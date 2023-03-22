package com.mall.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * (User)表实体类
 *
 * @author Mr.Z
 * @since 2023-03-21 18:29:21
 */
@SuppressWarnings("serial")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User extends Model<User> {
    private static final long serialVersionUID = -61698051714578605L;

    private Integer userId;
    // 用户名
    private String userName;
    // 用户昵称
    private String userNickname;
    // 密码
    private String userPassword;
    // 用户真实姓名
    private String userRealname;
    // 用户性别 0 | 1
    private Integer userGender;
    // 用户生日
    private Date userBirthday;
    // 用户地址
    private String userAddress;
    // 用户“祖籍”
    private String userHomeplace;
    // 头像地址
    private String userProfilePictureSrc;
    /**
     * 角色列表
     */
    @TableField(exist = false)
    private List<MallRole> mallRoleList;
    /**
     * 记得我
     */
    @TableField(exist = false)
    private Boolean rememberMe;
}

