package com.xq.web.controller;

import com.xq.bean.Employee;
import com.xq.bean.EmployeePojo;
import com.xq.bean.Station;
import com.xq.service.EmployeeService;
import com.xq.service.StationService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.List;

@Controller
public class UserController {


}
