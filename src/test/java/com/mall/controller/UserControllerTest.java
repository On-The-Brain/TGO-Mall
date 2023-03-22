// package com.mall.controller;
//
// import org.junit.jupiter.api.Test;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.http.ResponseEntity;
//
// import javax.annotation.Resource;
//
// /**
//  * @author : Mr.Zhang
//  * @version : 1.0
//  * @package : com.mall.controller
//  * @ClassName : UserControllerTest
//  * @projectName : TGO-Mall
//  * @date : 2023/3/17 19:22
//  */
// @SpringBootTest
// class UserControllerTest {
//     @Resource
//     UserController userController = new UserController();
//
//     @Test
//     void selectAdminManagement() {
//         ResponseEntity<Object> objectResponseEntity = userController.selectAdminManagement("zs", "Admin", 4, 1);
//         System.out.println("objectResponseEntity = " + objectResponseEntity);
//     }
// }