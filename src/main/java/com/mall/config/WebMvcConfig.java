package com.mall.config;

import com.mall.util.Constants;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     * 添加资源处理程序
     * 引入本地路径作为虚拟路径
     *
     * @param registry 注册表
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // windows
        registry.addResourceHandler(Constants.REFERENCE_PATH_NAME)
                .addResourceLocations(Constants.PROJECT_RESOURCE_PATH)//项目资源路径
                .addResourceLocations(Constants.WIN_VIRTUAL_ROUTE);// 本地路径
        //linux
        registry.addResourceHandler(Constants.REFERENCE_PATH_NAME)
                .addResourceLocations(Constants.PROJECT_RESOURCE_PATH)//项目资源路径
                .addResourceLocations(Constants.LIN_VIRTUAL_ROUTE);// 本地路径
    }

    /**
     * 配置项目启动页面
     *
     * @param registry 注册表
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("forward:loginUser/start");
    }
}