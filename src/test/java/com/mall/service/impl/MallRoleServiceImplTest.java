package com.mall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mall.entity.MallProduct;
import com.mall.entity.MallRole;
import com.mall.mapper.MallProductImgMapper;
import com.mall.mapper.MallProductMapper;
import com.mall.service.MallProductService;
import com.mall.service.MallRoleService;
import com.mall.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author : Mr.Zhang
 * @version : 1.0
 * @package : com.mall.service.impl
 * @ClassName : MallRoleServiceImplTest
 * @projectName : TGO-Mall
 * @date : 2023/3/13 19:02
 */
@SpringBootTest
class MallRoleServiceImplTest {
    @Resource
    MallRoleService mallRoleService;
    @Resource
    UserService userService;
    @Resource
    MallProductImgMapper mallProductImgMapper;
    @Resource
    MallProductMapper mallProductMapper;
    @Resource
    MallProductService mallProductService;

    @Test
    void queryAllAdminRole() {
        Map<String, Object> map = mallRoleService.selectByListPage(1, 1);
        // System.out.println("map = " + map.size());
        Object rows = map.get("rows");
        System.out.println(map);
    }

    // @Test
    // void selectByListPage() {
    //     MallUser mallUser = new MallUser();
    //     Page<MallUser> page = new Page<>(1, 6);
    //     QueryWrapper<MallUser> wrapper = new QueryWrapper<>();
    //
    //
    //     Map<String, Object> map = new HashMap<>();
    //     map.put("rows", mallUsers);
    //     map.put("total", page.getTotal());
    //
    //     System.out.println("map = " + map);
    //     // System.out.println("mallUser1 ============================================ " + mallUsers);
    //
    // }

    @Test
    void queryByField() {
        // List<MallProductVo> mallProductVos = mallProductService.selectHotSellingArea();
        // mallProductVos.forEach(System.out::println);
        List<MallRole> mallRoles = mallRoleService.queryAllAdminRole();
        System.out.println("mallRoles = " + mallRoles);
    }

    @Test
    void createRole() {
        List<MallProduct> mallProducts = mallProductService.selectHotSellingArea();
        System.out.println("mallProducts = " + mallProducts);
    }

    @Test
    void removeRole() {
        List<MallProduct> mallProducts = mallProductService.mallProductList(6);
        System.out.println("mallProducts = " + mallProducts);
    }

    @Test
    void updateRole() {
        QueryWrapper<MallProduct> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("mpi.product_parallelism", "1");
        // MallProduct mallProduct = mallProductMapper.selectProduct(queryWrapper);
        // System.out.println("mallProductVos = " + mallProducts);
    }
}