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

/**
 * 建站-商品评论表
 *
 * @TableName mall_product_comment
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("mall_product_comment")
public class MallProductComment implements Serializable {
    /**
     * 评论id
     */
    @TableId(type = IdType.NONE)
    private Long commentId;

    /**
     * 评论的产品ID
     */
    @TableField(value = "mall_product_id")
    private String mallProductId;

    /**
     * 评论的用户ID
     */
    @TableField(value = "mall_user_id")
    private Integer mallUserId;

    /**
     * 评论的内容
     */
    @TableField(value = "comment_content")
    private String commentContent;

    /**
     * 评论的状态
     */
    @TableField(value = "comment_status")
    private Integer commentStatus;

    /**
     * 评论的时间
     */
    @TableField(value = "comment_created")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date commentCreated;

    /**
     * 产品满意度
     */
    @TableField(value = "comment_product_starLevel")
    private Integer commentProductStarlevel;

    private static final long serialVersionUID = 1L;
}