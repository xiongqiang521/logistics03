package com.xq.shiro;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.mgt.RememberMeManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import java.util.*;

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
         * Shiro内置过滤器，可以实现权限相关的拦截器
         *    常用的过滤器：
         *       anon: 无需认证（登录）可以访问
         *       authc: 必须认证才可以访问
         *       user: 如果使用rememberMe的功能可以直接访问
         *       perms： 该资源必须得到资源权限才可以访问
         *       role: 该资源必须得到角色权限才可以访问
         */

        Map<String, String> filterMap = new LinkedHashMap<>();

        //释放静态资源
        filterMap.put("/static/**","anon");
        filterMap.put("/UsersByNameAndPassword","anon");
        filterMap.put("/Message","anon");
        filterMap.put("/MessageLogin","anon");
        filterMap.put("/MessageRegister","anon");
        filterMap.put("/css/**","anon");
        filterMap.put("/font/**","anon");
        filterMap.put("/fonts/**","anon");
        filterMap.put("/images/**","anon");
        filterMap.put("/js/**","anon");
        filterMap.put("/lib.layui/**","anon");
        filterMap.put("/user.json","anon");
        //放行页面
        filterMap.put("/login.html", "anon");
        filterMap.put("/login", "anon");
        filterMap.put("/login-nose.html", "anon");
        filterMap.put("/user-add.html", "anon");
        filterMap.put("/**","user");

        //授权过滤器
        filterMap.put("/orders/*", "roles[admin]");
        filterMap.put("/manager/*", "roles[manager]");
        filterMap.put("/user/*", "roles[orders,admin,manager]");
//        filterMap.put("/manager/*", "perms[manager]");
        // 通配拦截
        filterMap.put("/*", "authc");
        System.out.println(1111);
        //登录成功要跳转的连接
//        shiroFilterFactoryBean.setSuccessUrl("/index.html");
        //未登录的时候，跳转的登录页面
        shiroFilterFactoryBean.setLoginUrl("/login.html");
        //设置未授权提示页面
        shiroFilterFactoryBean.setUnauthorizedUrl("/unAuth.html");
         shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
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
        //用户授权认证信息Cache，采用EhCache缓存
        securityManager.setCacheManager(cacheManager());//配置缓存管理器
        securityManager.setRememberMeManager(rememberMeManager()); //配置记住我管理器
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

    /**
     * 緩存管理器
     */
    @Bean
    public CacheManager cacheManager(){
        return new MemoryConstrainedCacheManager();
    }

    /**
     * cookie对象
     */

    @Bean
    public SimpleCookie getSimpleCookie(){
        //这个参数是cookie的名称，对应前端的checkbox的那么 name=rememberMe
        SimpleCookie simpleCookie=new SimpleCookie("rememberMe");
        //设置cookie的存活时间
        simpleCookie.setMaxAge(259200);
        return simpleCookie;
    }

    /**
     * cookie管理对象，记住我功能
     * 添加cookie管理器Bean
     */
    @Bean
    public RememberMeManager rememberMeManager(){
        CookieRememberMeManager cookieRememberMeManager=new CookieRememberMeManager();
        cookieRememberMeManager.setCookie(getSimpleCookie());
        //rememberMe cookie加密的密钥 建议每个项目都不一样 默认AES算法 密钥长度(128 256 512 位)
        cookieRememberMeManager.setCipherKey(Base64.decode("2AvVhdsgUs0FSA3SDFAdag=="));
        return cookieRememberMeManager;
    }

    @Bean
    public SimpleMappingExceptionResolver simpleMappingExceptionResolver(){
        SimpleMappingExceptionResolver resolver=new SimpleMappingExceptionResolver();
        Properties properties=new Properties();
        //未授权页面处理
        properties.setProperty("org.apache.shiro.authz.UnauthorizedException","/unAuth");
        resolver.setExceptionMappings(properties);
        return resolver;
    }
}