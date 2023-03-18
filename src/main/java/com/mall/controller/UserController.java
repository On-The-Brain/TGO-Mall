package com.mall.controller;

import com.mall.service.MallUserService;
import com.mall.util.EnumCode;
import com.mall.util.ResponseData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;
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
    public ResponseEntity<Object> selectAdminManagement(@RequestParam(required = false, name = "field") String field, @RequestParam(required = false, name = "role") String role, @RequestParam(value = "size") Integer size, @RequestParam(value = "page") Integer page) {
        Map<String, Object> map = mallUserServiceImpl.queryAllMallUser(role, page, size, field);
        return ResponseEntity.ok(map);
    }

    /**
     * 更新用户角色
     *
     * @param map 角色id集合和用户id
     * @return {@link ResponseEntity}<{@link Integer}>
     */
    @ResponseBody
    @ApiOperation(value = "修改用户的角色信息")
    @ApiImplicitParam(name = "map", value = "角色id集合和用户id", required = true)
    @PostMapping("/admin/Management")
    public ResponseEntity<Integer> updateUserRole(@RequestBody Map<String, Object> map) {
        int roleId = Integer.parseInt(map.get("userId") + "");
        List<Integer> roleList = (List<Integer>) map.get("arr");
        int method = Integer.parseInt(map.get("method") + "");
        return ResponseEntity.ok(this.mallUserServiceImpl.updateUserRole(roleId, roleList, method));
    }

    @DeleteMapping("/admin/Management/{id}")
    @ResponseBody
    public ResponseData<Boolean> deleteUserRole(@PathVariable Integer id) {
        boolean b = mallUserServiceImpl.removeById(id);
        return ResponseData.generator(EnumCode.SUCCESS.getCode(), "注销成功", b);
    }

}
