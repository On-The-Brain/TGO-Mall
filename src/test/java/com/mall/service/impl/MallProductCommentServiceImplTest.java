package com.mall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.mall.controller.MallProductCommentController;
import com.mall.entity.MallProductComment;
import com.mall.mapper.MallProductCommentMapper;
import com.mall.service.MallProductCommentService;
import com.mall.util.ResponseData;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author : Mr.Zhang
 * @version : 1.0
 * @package : com.mall.service.impl
 * @ClassName : MallProductCommentServiceImplTest
 * @projectName : TGO-Mall
 * @date : 2023/3/17 9:16
 */
@SpringBootTest
class MallProductCommentServiceImplTest {
    @Resource
    MallProductCommentMapper mallProductCommentMapper;
    @Resource
    MallProductCommentService mallProductCommentServiceImpl;
    @Resource
    MallProductCommentController mallProductCommentController;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getBaseMapper() {
        LambdaQueryWrapper<MallProductComment> lambdaQueryWrapper = Wrappers.lambdaQuery();
        lambdaQueryWrapper.gt(MallProductComment::getMallProductId, "3vGiWOSX53");
        MallProductComment one = mallProductCommentServiceImpl.getOne(lambdaQueryWrapper);
        System.out.println("lambdaQueryWrapper = "+one);
    }

    @Test
    void getEntityClass() {
        LambdaQueryWrapper<MallProductComment> lambdaQueryWrapper=Wrappers.lambdaQuery();
        lambdaQueryWrapper.eq(MallProductComment::getMallProductId,"31KHcmlGCP");
        List<MallProductComment> list = mallProductCommentServiceImpl.list(lambdaQueryWrapper);
        System.out.println("list = " + list);
    }

    @Test
    void retBool() {
    }

    @Test
    void currentMapperClass() {
    }

    @Test
    void currentModelClass() {
    }

    @Test
    void sqlSessionBatch() {
    }

    @Test
    void closeSqlSession() {
    }

    @Test
    void sqlStatement() {
    }

    @Test
    void saveBatch() {
    }

    @Test
    void getSqlStatement() {
    }

    @Test
    void saveOrUpdate() {
    }

    @Test
    void saveOrUpdateBatch() {
    }

    @Test
    void updateBatchById() {
    }

    @Test
    void getOne() {
    }

    @Test
    void getMap() {
    }

    @Test
    void getObj() {
    }

    @Test
    void executeBatch() {
    }

    @Test
    void testExecuteBatch() {
    }

    @Test
    void testExecuteBatch1() {
    }

    @Test
    void removeById() {
    }

    @Test
    void removeByIds() {
    }

    @Test
    void testRemoveById() {
    }

    @Test
    void removeBatchByIds() {
    }

    @Test
    void testRemoveBatchByIds() {
    }

    @Test
    void save() {
    }

    @Test
    void testSaveBatch() {
    }

    @Test
    void testSaveOrUpdateBatch() {
    }

    @Test
    void testRemoveById1() {
    }

    @Test
    void testRemoveById2() {
    }

    @Test
    void testRemoveById3() {
    }

    @Test
    void removeByMap() {
    }

    @Test
    void remove() {
    }

    @Test
    void testRemoveByIds() {
    }

    @Test
    void testRemoveByIds1() {
    }

    @Test
    void testRemoveBatchByIds1() {
    }

    @Test
    void testRemoveBatchByIds2() {
    }

    @Test
    void testRemoveBatchByIds3() {
    }

    @Test
    void testRemoveBatchByIds4() {
    }

    @Test
    void updateById() {
    }

    @Test
    void update() {
    }

    @Test
    void testUpdate() {
    }

    @Test
    void testUpdateBatchById() {
    }

    @Test
    void getById() {
    }

    @Test
    void listByIds() {
    }

    @Test
    void listByMap() {
    }

    @Test
    void testGetOne() {
    }

    @Test
    void count() {
    }

    @Test
    void testCount() {
    }

    @Test
    void list() {
    }

    @Test
    void testList() {
    }

    @Test
    void page() {
    }

    @Test
    void testPage() {
    }

    @Test
    void listMaps() {
    }

    @Test
    void testListMaps() {
    }

    @Test
    void listObjs() {
    }

    @Test
    void testListObjs() {
    }

    @Test
    void testListObjs1() {
    }

    @Test
    void testListObjs2() {
    }

    @Test
    void pageMaps() {
    }

    @Test
    void testPageMaps() {
    }

    @Test
    void query() {
    }

    @Test
    void lambdaQuery() {
    }

    @Test
    void testLambdaQuery() {
    }

    @Test
    void ktQuery() {
    }

    @Test
    void ktUpdate() {
    }

    @Test
    void testUpdate1() {
    }

    @Test
    void lambdaUpdate() {
    }

    @Test
    void testSaveOrUpdate() {
    }
}