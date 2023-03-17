package com.mall.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mall.entity.MallProductComment;
import com.mall.mapper.MallProductCommentMapper;
import com.mall.service.MallProductCommentService;
import org.springframework.stereotype.Service;

/**
 * @author 夏有乔木，雅望天堂
 * @description 针对表【mall_product_comment(建站-商品评论表)】的数据库操作Service实现
 * @createDate 2023-03-17 09:00:05
 */
@Service
public class MallProductCommentServiceImpl extends ServiceImpl<MallProductCommentMapper, MallProductComment> implements MallProductCommentService {
}
