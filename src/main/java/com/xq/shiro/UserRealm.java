package com.xq.shiro;

import com.xq.bean.Users;
import com.xq.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 自定义Realm
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService service;

    /**
     * 执行授权逻辑
     *
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("执行授权逻辑");
        //给资源进行授权
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
        Subject subject = SecurityUtils.getSubject();
        Users users = (Users) subject.getPrincipal();
        Users user = service.login(users.getName());
        System.out.println("----------"+user.getState());
        info.addStringPermission(user.getState());
        return info;
    }

    /**
     * 执行认证逻辑
     *
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("执行认证逻辑");

        UsernamePasswordToken t = (UsernamePasswordToken) token;
        Users users = service.login(t.getUsername());
        System.out.println("name----------" + users);
        if(users==null){
            //判断用户名是否存在  否则底层会抛出UnKnowAccountException
            return null;
        }
        //判断密码是否正确
        return new SimpleAuthenticationInfo(users,users.getPassword(),"");

    }
    }
