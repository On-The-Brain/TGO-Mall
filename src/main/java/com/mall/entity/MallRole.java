package com.mall.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * (MallRole)实体类
 *
 * @author makejava
 * @since 2023-02-17 16:07:38
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName("mall_role")
public class MallRole implements Serializable {
    private static final long serialVersionUID = 528590509092063951L;
    /**
     * 角色id
     */
    @TableId(type = IdType.AUTO)
    private Integer mallRoleId;
    /**
     * 角色名
     */
    @TableField(value = "mall_role_name")
    private String mallRoleName;
    /**
     * 角色描述
     */
    @TableField(value = "mall_role_description")
    private String mallRoleDescription;
    /**
     * 权限列表
     */
    @TableField(exist = false)
    private List<MallPermission> mallPermissionList;
}

