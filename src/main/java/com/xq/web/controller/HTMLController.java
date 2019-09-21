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
    @RequestMapping({"*.html","*/*.html","*/*/*.html"})
    public String welcome() {
            return null;
    }
}