package com.mall.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (MallProductImg)表实体类
 *
 * @author Mr.Z
 * @since 2023-03-15 12:58:49
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MallProductImg implements Serializable {

    // 商品图片id
    @TableId(type = IdType.NONE)
    private Integer productImgId;

    @TableField(value = "product_img_path")
    // 图片路径
    private String productImgPath;
    /**
     * 产品并行性
     */
    @TableField(value = "product_parallelism")
    private String productParallelism;

    /**
     * 产品介绍
     */
    @TableField(value = "product_introduce")
    private String productIntroduce;
}

