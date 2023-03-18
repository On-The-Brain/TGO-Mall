package com.mall.controller;

import com.mall.entity.MallPermission;
import com.mall.entity.MallRole;
import com.mall.service.MallPermissionService;
import com.mall.service.MallRoleService;
import com.mall.util.ResponseData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

/**
 * (MallRole)表控制层
 *
 * @author makejava
 * @since 2023-02-17 16:07:38
 */
// @RestController
@RequestMapping("mallRole")
@Controller
public class MallRoleController {
    /**
     * 服务对象
     */
    @Resource
    private MallRoleService mallRoleService;
    @Resource
    private MallPermissionService mallPermissionService;

    @RequestMapping("/start")
    public ModelAndView start() {
        ModelAndView modelAndView = new ModelAndView();
        // 设置逻辑视图名
        modelAndView.setViewName("backstage/role_management");
        return modelAndView;
    }

    /**
     * 角色管理
     *
     * @return 单条数据
     */
    // HttpStatus.FORBIDDEN.value()
    @RequestMapping("roleManagement")
    @ResponseBody
    public Map<String, Object> roleManagement(@RequestParam(value = "size") Integer size, @RequestParam(value = "page") Integer page) {
        Map<String, Object> map = mallRoleService.selectByListPage(page, size);
        return map;
    }

    /**
     * 开始更新角色
     *
     * @param model 模型
     * @param index 指数
     * @return {@link String}
     */
    @GetMapping("roleUpdate/{index}")
    public String startRoleUpdate(@PathVariable("index") Integer index, Model model) {
        List<MallPermission> permissionList = mallPermissionService.queryAll();
        List<MallPermission> mallPermissions = mallPermissionService.queryById(index);
        List<MallPermission> collect = permissionList.stream().filter(item -> !mallPermissions.contains(item)).collect(toList());
        model.addAttribute("mallPermission", mallPermissions);
        model.addAttribute("PermissionAll", collect);
        return "backstage/role_authorization";
    }


    /**
     * 查询权限字段
     *
     * @param filed  提起
     * @param choose 选择
     * @return {@link ResponseEntity}<{@link Object}>
     */
    @GetMapping("roleManagement/{filed}/{choose}")
    public ResponseEntity<Object> queryRoleByField(@PathVariable String filed, @PathVariable("choose") String choose) {
        boolean flag = false;
        MallRole mallRole = mallRoleService.queryByField(filed, choose);
        if (mallRole == null) {
            flag = true;
        }
        System.out.println(ResponseEntity.ok(flag));
        return ResponseEntity.ok(flag);
    }

    /**
     * 创建角色
     * <p>
     * // * @param array 数组
     *
     * @return {@link ResponseEntity}<{@link Object}>
     */
    @PostMapping("roleManagement")
    @ResponseBody
    public ResponseEntity<Object> createRole(@RequestBody Map map) {
        System.out.println("map = " + map.get("list"));
        List list = (List) map.get("list");
        // 前端传递一个对象
        HttpStatus status;

        Map<String, Integer> role = mallRoleService.createRole(new MallRole(null, map.get("mallRoleName") + "", map.get("mallRoleDescription") + "", null), list);
        if (role.get("RoleCount") > 0) {
            status = HttpStatus.OK;
        } else {
            status = HttpStatus.NOT_MODIFIED;
        }
        return new ResponseEntity<>(role, null, status);
    }

    /**
     * 删除通过id
     * 删除数据
     *
     * @param mallRoleId 角色id
     * @return 删除是否成功
     */
    @DeleteMapping("roleManagement/{mallRoleId}")
    public ResponseEntity<Object> removeById(@PathVariable Integer mallRoleId) {
        return ResponseEntity.ok(this.mallRoleService.removeRole(mallRoleId));
    }

    /**
     * 修改角色权限
     *
     * @return 删除是否成功
     */
    @PostMapping("roleManagement/expand")
    public ResponseEntity<Object> updateRole(@RequestBody Map<String, Object> map) {
        int roleId = Integer.parseInt(map.get("roleId") + "");
        int method = Integer.parseInt(map.get("method") + "");
        List<Integer> permissionsList = (List<Integer>) map.get("permissionsList");
        return ResponseEntity.ok(this.mallRoleService.updateRole(roleId, permissionsList, method));
    }

    /**
     * 角色列表
     *
     * @return {@link ResponseData}<{@link Object}>
     */
    @GetMapping("message/one")
    @ResponseBody
    public ResponseData<Object> mallRoleList() {
        List<MallRole> list = mallRoleService.list();
        return ResponseData.success(list);
    }
}

