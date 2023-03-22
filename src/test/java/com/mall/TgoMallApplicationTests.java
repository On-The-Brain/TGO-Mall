// package com.mall;
//
// import com.mall.mapper.MallRoleMapper;
// import org.junit.jupiter.api.Test;
// import org.mybatis.spring.annotation.MapperScan;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.context.SpringBootTest;
//
// import javax.annotation.Resource;
// import javax.sql.DataSource;
// import java.sql.SQLException;
//
// @SpringBootTest
// @MapperScan("com.mall.mapper")
// class TgoMallApplicationTests {
//
//     @Autowired
//     DataSource dataSource;
//     @Resource
//     MallRoleMapper mallRoleMapper;
//     @Resource
//     MallUserService mallUserServiceImpl;
//
//     @Test
//     void contextLoads() throws SQLException {
//         System.out.println(dataSource.getConnection());
//     }
//
//     @Test
//     void context() throws SQLException {
//         // boolean b = StringUtils.hasText("");
//         // boolean b1 = StringUtils.hasText("  ");
//         // boolean b2 = StringUtils.hasText(null);
//         // boolean b3 = StringUtils.hasText("dasd");
//         // System.out.println("b = " + b);
//         System.out.println();
//     }
// }
