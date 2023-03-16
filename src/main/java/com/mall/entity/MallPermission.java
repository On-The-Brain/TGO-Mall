package com.mall.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (MallPermission)实体类
 *
 * @author makejava
 * @since 2023-02-17 16:07:38
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("mall_permission")
public class MallPermission implements Serializable {
    /**
     * 权限id
     */
    @TableId(type = IdType.AUTO)
    private Integer mallPermissionId;
    /**
     * 权限名称
     */
    @TableField(value = "mall_permission_name")
    private String mallPermissionName;
    /**
     * 权限描述
     */
    @TableField(value = "mall_permission_description")
    private String mallPermissionDescription;

}

