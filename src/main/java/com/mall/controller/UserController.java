package com.mall.controller;

import com.mall.service.MallUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author : Mr.Zhang
 * @version : 1.0
 * @package : com.mall.controller
 * @ClassName : UserController
 * @projectName : TGO-Mall
 * @date : 2023/3/14 20:21
 */
@CrossOrigin
// @RestController
@Api(value = "测试SwaggerAPI Annotation", tags = "Swagger测试之用户信息管理API")
@Controller
@RequestMapping("user")
public class UserController {

    @Resource
    MallUserService mallUserServiceImpl;

    // 起始转发到admin_management.html页面的请求
    @RequestMapping("/admin/start")
    public ModelAndView start() {
        ModelAndView modelAndView = new ModelAndView();
        // 设置逻辑视图名
        modelAndView.setViewName("backstage/admin_management");
        return modelAndView;
    }

    @GetMapping("/admin/Management")
    @ApiOperation(value = "获取所有管理员信息", notes = "可以搜索")
    @ApiImplicitParam(name = "mallUser", value = "传递一个对象", required = true)
    @ResponseBody
    public ResponseEntity<Object> selectAdminManagement(@RequestParam(required = false, name = "field") String field,
                                                        @RequestParam(required = false, name = "role") String role,
                                                        @RequestParam(value = "size") Integer size,
                                                        @RequestParam(value = "page") Integer page) {
        Map<String, Object> map = mallUserServiceImpl.queryAllMallUser(role, page, size, field);
        return ResponseEntity.ok(map);
    }

}
