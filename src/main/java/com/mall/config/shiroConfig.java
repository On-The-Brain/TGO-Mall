package com.mall.config;

// import com.mall.shiro.CustomRolesAuthorizationFilter;
import com.mall.shiro.MallRealm;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * anon:无需认证就可以访问
 * authc:
 * 必须认证了才能让问
 * user:
 * 必须棚有记住我功能才能用
 * perms:
 * 拥有对某个资源的权限才能访问：
 * role:
 * 拥有某个角色权限才能访问
 */
@Configuration
public class shiroConfig {

    // Filter工厂，设置对应的过滤条件和跳转条件
    @Bean(name = "shiroFilterFactoryBean")
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("securityManager") SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        // 引用指定的安全管理器 必须配置
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
        // 登录
        shiroFilterFactoryBean.setLoginUrl("/loginUser/start");
        // 首页
        shiroFilterFactoryBean.setSuccessUrl("/index");
        // 错误页面，认证不通过跳转
        shiroFilterFactoryBean.setUnauthorizedUrl("/403");

        // shiroFilterFactoryBean.setFilters((Map<String, Filter>) new HashMap<>().put("roles", new CustomRolesAuthorizationFilter()));
        // // 自定义拦截器链
        // // 退出 过滤器
        // filterChainDefinitionMap.put("/logout", "/loginUser/logout");
        // // 静态资源不做拦截
        // filterChainDefinitionMap.put("/static/resources/**", "anon");
        // filterChainDefinitionMap.put("/static/theme/**", "anon");
        // // 对后台首页接口进行角色权限验证
        // filterChainDefinitionMap.put("/loginUser/backstageIndex", "authc,user,roles[\"role.superAdmin,role.orderAdministrator,role.commodityManager,role.systemAdmin\"]");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }


    @Bean
    @ConditionalOnMissingBean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator defaultAAP = new DefaultAdvisorAutoProxyCreator();
        defaultAAP.setProxyTargetClass(true);
        return defaultAAP;
    }

    // 将自己的验证方式加入容器
    @Bean
    public MallRealm mallRealm() {
        return new MallRealm();
    }

    // 权限管理，配置主要是Realm的管理认证
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager securityManager(@Qualifier("mallRealm") MallRealm mallRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 关联一个授权规则域(指定认证授权规则)
        securityManager.setRealm(mallRealm());
        // 记住我
        securityManager.setRememberMeManager(rememberMeManager());
        // 关联一个会话管理器
        securityManager.setSessionManager(sessionManager());
        return securityManager;
    }


    // 记住我
    @Bean
    public CookieRememberMeManager rememberMeManager() {
        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
        cookieRememberMeManager.setCookie(cookie());
        return cookieRememberMeManager;
    }

    // cookie 配置
    @Bean
    public SimpleCookie cookie() {
        SimpleCookie simpleCookie = new SimpleCookie();
        simpleCookie.setName("rememberMe");
        // cookie只在http请求中可⽤，那么通过js脚本将⽆法读取到cookie信息，有效防⽌cookie被窃取
        simpleCookie.setHttpOnly(true);
        // Cookie过期时间
        simpleCookie.setMaxAge(604800);
        return simpleCookie;
    }

    // session 配置
    @Bean
    public DefaultWebSessionManager sessionManager() {
        DefaultWebSessionManager defaultWebSessionManager = new DefaultWebSessionManager();
        // session过期时间
        defaultWebSessionManager.setGlobalSessionTimeout(1800000);
        return defaultWebSessionManager;
    }


    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }
}