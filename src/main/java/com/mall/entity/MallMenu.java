package com.mall.entity;

import java.io.Serializable;

/**
 * (MallMenu)实体类
 *
 * @author makejava
 * @since 2023-02-21 15:39:20
 */
public class MallMenu implements Serializable {
    private static final long serialVersionUID = -24849636471938623L;
    /**
     * 菜单id
     */
    private Integer menuId;
    /**
     * 父节点id
     */
    private Integer parentId;
    /**
     * 菜单名称
     */
    private String menuName;
    /**
     * 菜单链接
     */
    private String menuUrl;
    /**
     * 菜单状态
     */
    private String menuStatus;
    /**
     * 菜单等级
     */
    private Integer menuLevel;
    /**
     * 菜单图标
     */
    private String menuIcon;
    /**
     * 角色id
     */
    private Integer mallRoleId;

}

