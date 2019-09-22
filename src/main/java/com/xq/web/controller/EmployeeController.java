package com.xq.web.controller;

import com.xq.bean.Employee;
import com.xq.bean.EmployeePojo;
import com.xq.bean.Station;
import com.xq.service.EmployeeService;
import com.xq.service.EmployeeStateService;
import com.xq.service.StationService;
import com.xq.util.PageBean;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class EmployeeController {

    @RequestMapping("/hello")
    public ModelAndView index(ModelAndView mv){
        System.out.println("员工");
        mv.setViewName("redirect:/index.html");
        return mv;
    }


    @Resource
    private EmployeeService employeeService;

    @Resource
    private StationService stationService;

    @Resource
    private EmployeeStateService employeeStateService;



    //查询所有管理人员
    @RequestMapping("/admin-list.html")
    @ResponseBody
    public ModelAndView getAll(ModelAndView mv,String pageNum){
        List<Employee> employee = employeeService.getAll();
        //将获取到的管理员信息添加域中
        System.out.println(employee);
        mv.addObject("employee",employee);
        //分页数据

        List pageNums = this.pagebean(pageNum);

        mv.addObject("pageNum",pageNums);
        //
        mv.setViewName("admin-list");
        return mv;
    }

    /**
     * 员工注册的下拉列表
     * @param model
     * @return
     */
    @RequestMapping("/admin-add.html")
    public Model getName(Model model){
        List<Station> stations = stationService.getStationname();
        model.addAttribute("stations",stations);
        return model;
    }

    //管理员注册
    @RequestMapping("/UserRegister")
    @ResponseBody
    public EmployeePojo employeeRegist(EmployeePojo employee) throws ParseException {
     employeeService.EmployeeRegist(employee);
        System.out.println(employee);
        return employee;
    }

    @RequestMapping("/unAuth")
    public String unAuth(){
        return "unAuth";
    }

    /**
     *    使用shiro 验证登录
     * @param name
     * @param password
     * @param mv
     * @return
     */
    @RequestMapping("/login")
    public ModelAndView login(String name, String password, ModelAndView mv, HttpServletRequest request){
        //使用shiro编写认证操作
        //1.获取Subject
        Subject subject = SecurityUtils.getSubject();
        //封装用户信息
        UsernamePasswordToken token=new UsernamePasswordToken(name,password);
        System.out.println("manager-----------"+name+password);
        try {
            Employee employee = employeeService.login(Integer.valueOf(name));
            if(employee!=null){
                request.getSession().setAttribute("name",employee.getName());
            }
            subject.login(token);
            mv.setViewName("redirect:/index.html");
            System.out.println(222);
            return mv;
        } catch (Exception e) {
            //登录失败：用户名不存在或密码错误
            mv.setViewName("login.html");
            mv.addObject("msg","用户名或密码错误");
            System.out.println(111);
            return mv;
        }
    }


    /**
     * 分页数据
     */
    @RequestMapping("/pageBean")
    @ResponseBody
    public List pagebean(String pageNum){
        List list= new ArrayList<>();;
        //当前员工的总数
        Integer count = employeeService.count();
        //页码容量为10  计算总页码数
        Integer totalPage = (count+ 9) / 10;
        for (int i=1; i<=totalPage;i++){
            list.add(i);
        }
        List<Employee> employees = employeeService.pageAll();
        for (Employee employee : employees) {
            System.out.println("employee---------"+employee);
        }
        System.out.println("pageNum--------"+pageNum);
        return list;
    }

}
