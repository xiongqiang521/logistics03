package com.xq.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * 访问templates里的动态页面
 *
 * @author Mechrevo
 * @version v1.0
 * 2019/9/18 9:04
 */
@Controller
public class HTMLController {
    @RequestMapping("*.html")
        public String welcome(HttpServletRequest request) {
        /*
        备用，返回null测试没问题，不明白为什么，如果返回null找不到页面404，使用下面的替代null
        return request.getServletPath().(1substring).replace(".html", "");
        */
            return null;
    }
}