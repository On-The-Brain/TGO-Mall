package com.mall.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * (MallProduct)表实体类
 *
 * @author Mr.Z
 * @since 2023-03-15 12:52:31
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("mall_product")
@SuppressWarnings("serial")
public class MallProduct implements Serializable {
    // 商品id
    @TableId(type = IdType.NONE)
    private String mallProductId;
    // 商品对应图片
    @TableField(value = "product_parallelism")
    private String productParallelism;
    // 商品标题
    @TableField(value = "mall_product_title")
    private String mallProductTitle;
    // 商品类别id
    @TableField(value = "mall_category_Id")
    private Integer mallCategoryId;
    // 商品价格
    @TableField(value = "mall_product_price")
    private Double mallProductPrice;
    // 商品库存
    @TableField(value = "mall_product_num")
    private Integer mallProductNum;
    // 商品添加时间
    @TableField(value = "mall_product_created_time")
    private Date mallProductCreatedTime;
    // 商品状态，1-正常，2-下架，3-删除
    @TableField(value = "mall_product_state")
    private Integer mallProductState;
    // 排序字段
    @TableField(value = "mall_product_sort")
    private Integer mallProductSort;
    /**
     * 商场商品本质
     */
    @TableField(value = "mall_natureOfGoods")
    private String mallNatureOfGoods;
    /**
     * 商场折扣
     */
    @TableField(value = "mall_discount")
    private Double mallDiscount;
    @TableField(exist = false)
    private List<MallProductImg> productImgList;

}

