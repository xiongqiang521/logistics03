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

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

        Subject subject = SecurityUtils.getSubject();
        Employee users = (Employee) subject.getPrincipal();
        //利用登录的信息来用户当前的角色或权限
        Set<String> roles=new HashSet<>();
        roles.add("admin");
        if("orders".equals(users.getEmployeeState().getType())){
            roles.add("orders");
            roles.add("manager");
        }

      SimpleAuthorizationInfo info=new SimpleAuthorizationInfo(roles);
 //         Subject subject = SecurityUtils.getSubject();
  //      Employee users = (Employee) subject.getPrincipal();
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
