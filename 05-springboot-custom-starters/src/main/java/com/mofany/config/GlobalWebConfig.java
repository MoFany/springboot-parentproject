package com.mofany.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author MoFany-J
 * @date 2023/1/18
 * @description GlobalWebConfig 全局web配置
 */
@Configuration
public class GlobalWebConfig implements WebMvcConfigurer {
    /**
     * 添加资源处理器：用于处理静态资源放行
     * */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        //样式放行
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
        //视图页放行
        registry.addResourceHandler("/templates/**")
                .addResourceLocations("classpath:/templates/");

    }

    /**
     * 添加视图控制器：用于进行视图跳转(有这个存在对于简单的视图跳转可以省略视图控制器即controller)
     * 视图跳转的页面无需进行静态资源放行
     *
     * 如果你的静态资源放在templates下的一个目录下则请求地址需要带上它并需要return出去
     * */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //无业务逻辑跳转至登录页
        registry.addViewController("/login")
                .setViewName("html/login");

        //无业务逻辑跳转至注册页
        registry.addViewController("/register")
                .setViewName("html/register");
    }
}
