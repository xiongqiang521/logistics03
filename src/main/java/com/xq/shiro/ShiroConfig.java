package com.xq.shiro;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

@Configuration
public class ShiroConfig {
    /**
     * 创建shiroFilterFactoryBean
     */
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager) {
        //设置安全管理器
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        /**
         *          Shiro内置过滤器，可以实现权限相关的拦截器
         *          常用的过滤器：
         *          anon: 无需认证（登录）可以访问
         *          perms：该资源必须得到资源权限才可以访问
         *          authc: 必须认证才可以访问
         *          user: 如果使用rememberMe的功能可以直接访问
         *          role: 该资源必须得到角色权限才可以访问
         */

        Map<String, String> filterMap = new LinkedHashMap<>();
        //放行页面
        filterMap.put("/login.html", "anon");
        filterMap.put("/login", "anon");
        //授权过滤器
        filterMap.put("/*", "perms[jinli]");
        filterMap.put("/user/*", "perms[y:g]");
        // 通配拦截
        filterMap.put("/*", "authc");
        System.out.println(1111);
        //登录成功要跳转的连接
        shiroFilterFactoryBean.setSuccessUrl("/index.html");
        //未登录的时候，跳转的登录页面
        shiroFilterFactoryBean.setLoginUrl("/login.html");
        //设置未授权提示页面
        shiroFilterFactoryBean.setUnauthorizedUrl("/unAuth");
        // shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
        return shiroFilterFactoryBean;
    }


    /**
     * 创建DefaultWebSecurityManager
     */
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联userRealm
        securityManager.setRealm(userRealm);
        return securityManager;
    }


    /**
     * 创建Realm
     */
    @Bean(name = "userRealm")
    public UserRealm getRealm() {
        return new UserRealm();
    }


    /**
     * 配置shiroDialect,用于结合thymeleaf和shiro标签配合使用
     */
    @Bean
    public ShiroDialect getShiroDialect() {
        return new ShiroDialect();
    }
}