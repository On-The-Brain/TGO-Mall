package com.mall.controller;


import com.mall.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.Map;

/**
 * (User)表控制层
 *
 * @author Mr.Z
 * @since 2023-03-21 18:29:20
 */
@RestController
@RequestMapping("user")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    @RequestMapping("/start")
    public ModelAndView start() {
        ModelAndView modelAndView = new ModelAndView();
        // 设置逻辑视图名
        modelAndView.setViewName("backstage/admin_management");
        return modelAndView;
    }

    /**
     * 选择管理管理
     *
     * @param field 场
     * @param role  角色
     * @param size  大小
     * @param page  页面
     * @return {@link ResponseEntity}<{@link Object}>
     */
    @GetMapping("/admin/Management")
    @ApiOperation(value = "获取所有管理员信息", notes = "可以搜索")
    @ApiImplicitParam(name = "mallUser", value = "传递一个对象", required = true)
    @ResponseBody
    public ResponseEntity<Object> selectAdminManagement(@RequestParam(required = false, name = "field") String field, @RequestParam(required = false, name = "role") String role, @RequestParam(value = "size") Integer size, @RequestParam(value = "page") Integer page) {
        Map<String, Object> map = userService.ListUser(role, page, size, field);
        return ResponseEntity.ok(map);
    }
}

