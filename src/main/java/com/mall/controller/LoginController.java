package com.mall.controller;

import com.mall.entity.MallRole;
import com.mall.entity.User;
import com.mall.service.MallRoleService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 商城用户控制器
 * (MallUser)表控制层
 *
 * @author 夏有乔木，雅望天堂
 * @date 2023/02/19
 * @since 2023-02-17 16:07:33
 */
@CrossOrigin
// @RestController
@Controller
@RequestMapping("/loginUser")
public class LoginController {

    @Resource
    private MallRoleService mallRoleService;

    // 起始转发到login页面的请求
    @RequestMapping("/start")
    public ModelAndView start() {
        ModelAndView modelAndView = new ModelAndView();
        // 设置逻辑视图名
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @PostMapping(value = "/userLogin")
    @ResponseBody
    public Map<String, Object> login(@RequestBody User user) {
        String original = user.getUserPassword();
        Map<String, Object> map = new HashMap<>();
        String code = null;
        // 得到一个主题对象:subject代表了当前的"user"用户
        Subject subject = SecurityUtils.getSubject();
        // 密码加密
        Md5Hash md5Hash = new Md5Hash(user.getUserPassword(), user.getUserName(), 1024);
        user.setUserPassword(md5Hash.toString());
        // 用于实现基于用户名/密码主体（Subject）身份认证。
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(), user.getUserPassword());
        token.setRememberMe(user.getRememberMe());
        // 调用登录方法
        // 执行认证登录请求传递令牌到Realm中进行认证
        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            throw new AuthenticationException("用户名或密码错误");
        }
        List<String> collect = mallRoleService.
                queryAllAdminRole().
                stream().
                map(MallRole::getMallRoleName).
                collect(Collectors.toList());
        System.out.println("collect = " + collect);
        // isAuthenticated 判断是否经过认证登录
        if (subject.isAuthenticated()) {
            for (boolean b : subject.hasRoles(collect)) {
                if (b) {
                    // 认证成功
                    code = "200-A";
                    map.put("code", code);
                    map.put("msg", "登录成功");
                    return map;
                }
            }
            code = "200";
            map.put("code", code);
            map.put("msg", "权限不够,正在跳转用户登录");
            return map;
        } else {
            // 未认证
            code = "403";
            map.put("code", code);
            map.put("msg", "未经过认证");
            return map;
        }
    }

    /**
     * 注销
     * 重定向到登录页面
     *
     * @return {@link String}
     */
    @GetMapping("/logout")
    public String logout(SessionStatus status) {
        if (status != null) {
            status.setComplete();
        }
        Subject subject = SecurityUtils.getSubject();
        if (subject != null) {
            subject.logout();
        }
        System.out.println(InternalResourceViewResolver.REDIRECT_URL_PREFIX + "redirect:login");
        return "redirect:/loginUser/start";
    }

    @GetMapping("/backstageIndex")
    public String index() {
        return "backstage/index";
    }

    @GetMapping("/backstageIndex/user")
    public void user(HttpServletResponse response) throws IOException {
        // model.addAttribute("username", user.getUserName());
        // model.addAttribute("password", user.getUserPassword());
        // String url = "http://localhost:8080/tmall/login"
        response.sendRedirect("http://localhost:8080/tmall/login");
    }


}

