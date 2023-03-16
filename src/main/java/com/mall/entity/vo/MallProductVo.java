package com.mall.entity.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.mall.entity.MallProductImg;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author : Mr.Zhang
 * @version : 1.0
 * @package : com.mall.entity.vo
 * @ClassName : MallProductVo
 * @projectName : TGO-Mall
 * @date : 2023/3/15 14:26
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MallProductVo implements Serializable {
    // 商品id
    @TableId(type = IdType.NONE)
    private String mallProductId;
    // 商品图片id
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
    private String  mallNatureOfGoods;
    /**
     * 商场折扣
     */
    @TableField(value = "mall_discount")
    private Double mallDiscount;
    // 商品图片id
    @TableId(type = IdType.NONE)
    private Integer productImgId;
    // 图片路径
    @TableField(value = "product_img_path")
    private String productImgPath;
    // private List<MallProductImg> mallProductImgList;
}
