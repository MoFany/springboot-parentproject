package com.mofany.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * @author MoFany-J
 * @date 2023/2/6
 * @description SecurityConfig
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private UserDetailsService userDetailsService;
    /**
     * 注入数据源
     */
    @Resource
    private DataSource dataSource;

    /**
     * 配置对象
     */
    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
        /**
         * 在initDao方法中初始化类时会创建 persistent_tokens 数据库表
         * */
        jdbcTokenRepository.setDataSource(dataSource);
        //jdbcTokenRepository.setCreateTableOnStartup(true); // 启动时创建表
        return jdbcTokenRepository;
    }

    /**
     * 密码加密对象
     */
    @Bean
    protected PasswordEncoder setPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * 认证
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //设置当前需要的UserDetailsService接口的实现类
        auth.userDetailsService(userDetailsService).passwordEncoder(setPasswordEncoder());
    }


    /**
     * 授权 用户权限
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /**
         * 配置URL的访问权限，即为请求授权
         * */
        http.authorizeRequests()
                .antMatchers("/", "/api/logout", "/user/login").permitAll() // 指定不用认证即可以访问的请求
                .antMatchers("/api/index").hasAnyRole("user", "root")
                .anyRequest().authenticated(); // 其余请求都需要先认证才能访问

        /**
         * 配置访问时跳转到的自定义登录页面
         * */
        http.formLogin()
                .loginPage("/login.html") // 设置自定义登录页
                .loginProcessingUrl("/user/login") // 指定自定义登录页的访问路径URL
                .defaultSuccessUrl("/success.html").permitAll(); // 默认登录成功后的跳转路径

        /**
         * 配置无权限访问跳转的自定义页面
         * */
        http.exceptionHandling().accessDeniedPage("/unauth.html");

        /**
         * 配置 RememberMe，即指定过期时间内自动登录
         * */
        http.rememberMe().tokenRepository(persistentTokenRepository())
                /**
                 * 设置token的有效时间，单位秒
                 * */
                .tokenValiditySeconds(60)
                /**
                 * 指定UserDetailsService接口实例，即实现类对象
                 * */
                .userDetailsService(userDetailsService);

        /**
         * 配置退出或注销时的映射地址
         * */
        http.logout().logoutUrl("/logout").logoutSuccessUrl("/api/logout").permitAll();

        /**
         * 关闭csrf跨站请求伪造防护，不然测试时我们无法正确认证，必须从请求发起的客户端传token
         * */
        http.csrf().disable();
    }
}
