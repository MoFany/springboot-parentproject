package com.mofany.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author MoFany-J
 * @date 2023/1/16
 * @description GlobalWebConfig 全局Web配置文件
 */
@Configuration
public class GlobalWebConfig implements WebMvcConfigurer {
    /**
     * 添加资源处理器，即静态资源放行
     * */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //视图页放行
//        registry.addResourceHandler("/templates/**")
//                .addResourceLocations("classpath:/templates/");
        //样式放行
//        registry.addResourceHandler("/static/**")
//                .addResourceLocations("classpath:/static/");
        //js放行
    }
}
