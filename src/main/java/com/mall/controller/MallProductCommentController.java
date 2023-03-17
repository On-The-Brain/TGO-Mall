package com.mall.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mall.entity.MallProductComment;
import com.mall.service.MallProductCommentService;
import com.mall.util.ResponseData;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

import static com.mall.util.ResponseData.success;

/**
 * 建站-商品评论表(MallProductComment)表控制层
 *
 * @author Mr.Z
 * @since 2023-03-17 09:09:50
 */
@RestController
@RequestMapping("mallProductComment")
public class MallProductCommentController {
    /**
     * 服务对象
     */
    @Resource
    private MallProductCommentService mallProductCommentService;

    /**
     * 分页查询所有数据
     *
     * @param page               分页对象
     * @param mallProductComment 查询实体
     * @return 所有数据
     */
    @GetMapping
    public ResponseData selectAll(Page<MallProductComment> page, MallProductComment mallProductComment) {
        return success(this.mallProductCommentService.page(page, new QueryWrapper<>(mallProductComment)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseData<MallProductComment> selectOne(@PathVariable Serializable id) {
        return success(this.mallProductCommentService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param mallProductComment 实体对象
     * @return 新增结果
     */
    @PostMapping
    public ResponseData<Boolean> insert(@RequestBody MallProductComment mallProductComment) {
        return success(this.mallProductCommentService.save(mallProductComment));
    }

    /**
     * 修改数据
     *
     * @param mallProductComment 实体对象
     * @return 修改结果
     */
    @PutMapping
    public ResponseData<Boolean> update(@RequestBody MallProductComment mallProductComment) {
        return success(this.mallProductCommentService.updateById(mallProductComment));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public ResponseData<Boolean> delete(@RequestParam("idList") List<Long> idList) {
        return success(this.mallProductCommentService.removeByIds(idList));
    }
}

