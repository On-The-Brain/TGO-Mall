// package com.mall.controller;
//
// import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
// import com.mall.entity.MallPermission;
// import com.mall.service.MallPermissionService;
// import org.junit.jupiter.api.Test;
// import org.springframework.boot.test.context.SpringBootTest;
//
// import javax.annotation.Resource;
// import java.util.List;
//
// /**
//  * @author : Mr.Zhang
//  * @version : 1.0
//  * @package : com.mall.controller
//  * @ClassName : MallPermissionControllerTest
//  * @projectName : TGO-Mall
//  * @date : 2023/3/13 20:12
//  */
// @SpringBootTest
// class MallPermissionControllerTest {
//     @Resource
//     MallPermissionService mallPermissionService;
//
//     @Test
//     void start() {
//     }
//
//     @Test
//     void queryAll() {
//     }
//
//     @Test
//     void permissionManagement() {
//         Page<MallPermission> mallPermissionPage = mallPermissionService.queryAllLike("商品", 3, 1);
//         System.out.println("mallPermissions = " + mallPermissionPage.getRecords());
//     }
//
//     @Test
//     void updatePermission() {
//     }
//
//     @Test
//     void addPermission() {
//     }
//
//     @Test
//     void queryPermissionByField() {
//     }
//
//     @Test
//     void deletePermission() {
//     }
// }