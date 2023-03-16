package com.mall.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * (MallUser)实体类
 *
 * @author makejava
 * @since 2023-02-17 16:07:36
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("mall_user")
public class MallUser implements Serializable {
    private static final long serialVersionUID = -61698051714578605L;
    /**
     * 用户id
     */
    @TableId(type = IdType.AUTO)
    private Integer mallUserId;
    /**
     * 用户名
     */
    @TableField(value = "mall_username")
    private String mallUsername;
    /**
     * 密码
     */
    @TableField(value = "mall_password")
    private String mallPassword;
    /**
     * 用户昵称
     */
    @TableField(value = "mall_nick_name")
    private String mallNickName;
    /**
     * 性别 1男,2女
     */
    @TableField(value = "mall_user_sex")
    private Integer mallUserSex;
    /**
     * 生日
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @TableField(value = "mall_user_birthday")
    private Date mallUserBirthday;
    /**
     * 头像路径
     */
    @TableField(value = "mall_user_images")
    private String mallUserImages;
    /**
     * 手机号
     */
    @TableField(value = "mall_user_phone")
    private String mallUserPhone;
    /**
     * 注册时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @TableField(value = "mall_user_register_time")
    private Date mallUserRegisterTime;
    /**
     * 账户状态
     */
    @TableField(value = "mall_user_state")
    private Integer mallUserState;

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

