package com.mall.service.impl;

import com.mall.entity.MallPermission;
import com.mall.service.MallPermissionService;
import com.mall.util.RandomNumberUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : Mr.Zhang
 * @version : 1.0
 * @package : com.mall.service.impl
 * @ClassName : MallPermissionServiceImplTest
 * @projectName : TGO-Mall
 * @date : 2023/3/13 18:38
 */
@SpringBootTest
class MallPermissionServiceImplTest {

    @Resource
    MallPermissionService mallPermissionService;
    @Test
    void queryById() {
        List<MallPermission> mallPermissions = mallPermissionService.queryAll();
        System.out.println("mallPermissions = " + mallPermissions.size());
    }

    @Test
    void patchPermission() {
    }

    @Test
    void addPermission() {
    }

    @Test
    void queryByField() {
    }

    @Test
    void queryAllLike() {
    }

    @Test
    void deletePermission() {
    }
}