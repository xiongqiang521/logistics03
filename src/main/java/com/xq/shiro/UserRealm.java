package com.xq.shiro;

import com.xq.bean.Employee;
import com.xq.bean.Users;
import com.xq.service.EmployeeService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 自定义Realm
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private EmployeeService service;

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
        Employee users = (Employee) subject.getPrincipal();


        info.addStringPermission(users.getEmployeeState().getType());
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
        String username = t.getUsername();
        Integer integer = Integer.valueOf(username);
        Employee users = service.login(integer);
        System.out.println("name----------" + users);
        if(users==null){
            //判断用户名是否存在  否则底层会抛出UnKnowAccountException
            return null;
        }
        //判断密码是否正确
        return new SimpleAuthenticationInfo(users,users.getPassword(),"");

    }
    }
