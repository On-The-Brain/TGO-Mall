package com.mall.controller;

import com.mall.entity.MallUser;
import com.mall.service.MallUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * @author : Mr.Zhang
 * @version : 1.0
 * @package : com.mall.controller
 * @ClassName : RegisterController
 * @projectName : TGO-Mall
 * @date : 2023/3/14 13:45
 */

// @CrossOrigin
@Controller
@RequestMapping("/register")
public class RegisterController {
    /**
     * 服务对象
     */
    @Resource
    private MallUserService mallUserServiceImpl;

    /**
     * 起始转发到register页面的请求
     *
     * @return {@link ModelAndView}
     */
    @GetMapping("/start")
    public ModelAndView register() {
        ModelAndView modelAndView = new ModelAndView();
        // 设置逻辑视图名
        modelAndView.setViewName("register");
        return modelAndView;
    }

    /**
     * 条款
     *
     * @return {@link ModelAndView}
     */
    @RequestMapping("/clause/start")
    public ModelAndView clause() {
        ModelAndView modelAndView = new ModelAndView();
        // 设置逻辑视图名
        modelAndView.setViewName("clause");
        return modelAndView;
    }

    /**
     * 查询用户根据名称或昵称查询
     *
     * @param mallUsername 用户名
     * @param mallNickName 昵称
     * @return {@link ResponseEntity}<{@link Object}>
     */
    @GetMapping("/registerMessage/{mallUsername}/{mallNickName}")
    public ResponseEntity<Object> queryUserByName(@PathVariable String mallUsername, @PathVariable String mallNickName) {

        if (StringUtils.hasText(mallNickName)) {
            boolean b = !mallUserServiceImpl.queryUserByName(mallNickName);
            return new ResponseEntity<>(b, null, HttpStatus.OK.value());
        } else {
            MallUser login = mallUserServiceImpl.login(mallUsername);
            if (login == null) {
                return new ResponseEntity<>(true, null, HttpStatus.OK);
            }
        }
        return null;
    }

    /**
     * 注册
     *
     * @param mallUser 商城用户
     * @return {@link ResponseEntity}<{@link Object}>
     */
    @PostMapping("/registerMessage")
    public ResponseEntity<Object> register(MallUser mallUser) {
        Boolean register = mallUserServiceImpl.register(mallUser);
        return ResponseEntity.ok(register);
    }
}
