package com.mall.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mall.entity.MallPermission;
import com.mall.entity.MallUser;
import com.mall.service.MallPermissionService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (MallPermission)表控制层
 *
 * @author makejava
 * @since 2023-02-17 16:07:38
 */
@Controller
@RequestMapping("permission")
public class MallPermissionController {
    /**
     * 服务对象
     */
    @Resource(name = "mallPermissionService")
    private MallPermissionService mallPermissionService;

    /**
     * 开始
     *
     * @return {@link String}
     */
    @RequestMapping("start")
    public String start() {
        return "backstage/authority_management";
    }

    /**
     * 查询所有
     *
     * @return {@link ResponseEntity}<{@link MallPermission}>
     */
    @GetMapping("permissionAll")
    public ResponseEntity<Object> queryAll() {
        List<MallPermission> mallPermissions = mallPermissionService.queryAll();
        return ResponseEntity.ok(mallPermissions);
    }

    /**
     * 权限管理
     *
     * @param size  条数
     * @param page  页数
     * @param field 场
     * @return ResponseEntity
     */
    @GetMapping("permissionManagement")
    @ResponseBody
    public ResponseEntity<Object> permissionManagement(@RequestParam(value = "size") Integer size, @RequestParam(value = "page") Integer page, @RequestParam String field) {
        // Page<Object> objects = PageHelper.startPage(page, size);
        Page<MallPermission> mallPermissionPage = mallPermissionService.queryAllLike(field, size, page);
        Map<String, Object> map = new HashMap<>();
        map.put("total", mallPermissionPage.getTotal());
        map.put("rows", mallPermissionPage.getRecords());
        map.put("code", HttpStatus.OK.value());
        map.put("msg", HttpStatus.OK);
        return ResponseEntity.ok(map);
    }

    /**
     * 更新许可
     *
     * @param permission 许可
     * @return {@link ResponseEntity}<{@link Object}>
     */
    @PutMapping("permissionManagement")
    @ResponseBody
    public ResponseEntity<Object> updatePermission(MallPermission permission) {
        Integer integer = mallPermissionService.patchPermission(permission);
        return ResponseEntity.ok(integer);
    }

    /**
     * 添加权限
     *
     * @param permission 许可
     * @return {@link ResponseEntity}<{@link Object}>
     */
    @PostMapping("permissionManagement")
    public ResponseEntity<Object> addPermission(MallPermission permission) {
        permission.setMallPermissionName("role." + permission.getMallPermissionName());
        Integer integer = mallPermissionService.addPermission(permission);
        HttpStatus status;
        if (integer > 0) {
            status = HttpStatus.OK;
        } else {
            status = HttpStatus.NOT_MODIFIED;
        }
        return new ResponseEntity<>(integer, null, status);
        // User user = (User) SecurityUtils.getSubject().getPrincipal();
    }

    /**
     * 查询权限字段
     *
     * @param filed  提起
     * @param choose 选择
     * @return {@link ResponseEntity}<{@link Object}>
     */
    @GetMapping("permissionManagement/{filed}/{choose}")
    public ResponseEntity<Object> queryPermissionByField(@PathVariable String filed, @PathVariable("choose") String choose) {
        boolean flag = false;
        MallPermission permission = mallPermissionService.queryByField(filed, choose);
        if (permission == null) {
            flag = true;
        }
        System.out.println(ResponseEntity.ok(flag));
        return ResponseEntity.ok(flag);
    }

    /**
     * 删除权限
     *
     * @param permissionId 权限id
     * @param password     密码
     * @return {@link ResponseEntity}<{@link Object}>
     */
    @DeleteMapping("permissionManagement/{permissionId}/{password}")
    public ResponseEntity<Object> deletePermission(@PathVariable Integer permissionId, @PathVariable("password") String password) {
        Md5Hash md5Hash = new Md5Hash(password, "mall", 1024);
        MallUser mallUser = (MallUser) SecurityUtils.getSubject().getPrincipal();
        if (mallUser.getMallPassword().equals(md5Hash.toString())) {
            Integer integer = mallPermissionService.deletePermission(permissionId);
            return ResponseEntity.ok(integer);
        } else {
            return new ResponseEntity<>("密码不正确,拒绝删除", null, HttpStatus.NON_AUTHORITATIVE_INFORMATION);
        }
    }
}

