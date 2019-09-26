package com.xq.web.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class EmployeeController {
    //
    // @RequestMapping("/hello")
    // public ModelAndView index(ModelAndView mv){
    //     System.out.println("员工");
    //     mv.setViewName("index.html");
    //     return mv;
    // }


    @Resource
    private EmployeeService employeeService;

    @Resource
    private StationService stationService;

    @Resource
    private EmployeeStateService employeeStateService;


    /**
     * 查询所有管理人员
     * @param mv
     * @return
     */
    @RequestMapping("/admin-list.html")
    @ResponseBody
    public ModelAndView getAll(ModelAndView mv){
//        List<Employee> employee = employeeService.getAll();
        //将获取到的管理员信息添加域中
        Page<Employee> pageAll = employeeService.getPageAll(0, 10);
        //查询到的分页数据转换成集合
        List<Employee> employee = pageAll.getResult();
        //下拉列表
        List<Station> stations = stationService.getStationname();
        mv.addObject("pageStations",stations);

        //设置分页时 上一页，下一页的数值
        List list=new ArrayList();
        for (int i = 0; i < pageAll.getPages(); i++) {
            list.add(i+1);
        }
       Integer pageNum=1;
       Integer pageNum1=1;
       Integer pageNum2=1;
        if(pageNum!=1){
            pageNum1 = pageNum-1;
        }else {
            pageNum1 =1;
        }
        if(pageAll.getPages()==pageNum2){
            pageNum2=pageAll.getPages();
        }else {
            pageNum2=pageNum+1;
        }

        mv.addObject("pageNum1",pageNum1);
        mv.addObject("pageNum2",pageNum2);
        mv.addObject("page",list);
        mv.addObject("employee",employee);
        mv.addObject("pageAll",pageAll);
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
    public ModelAndView login(String name, String password,Boolean rememberMe, ModelAndView mv, HttpServletRequest request){
        //使用shiro编写认证操作
        //1.获取Subject
        Subject subject = SecurityUtils.getSubject();
        //封装用户信息
        UsernamePasswordToken token=new UsernamePasswordToken(name,password);
        System.out.println("manager-----------"+name+password);
        //判断是否记住用户名密码
        if(rememberMe!=null){
            token.setRememberMe(rememberMe);

            System.out.println("------------"+rememberMe);
        }
        try {
            //将用户名添加到session中
            Employee employee = employeeService.login(Integer.valueOf(name));
            if(employee!=null){
                request.getSession().setAttribute("name",employee);
            }
            subject.login(token);
            mv.addObject("employee",employee.getName());
            mv.setViewName("index.html");
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
     * 分页
     * @param
     * @param
     * @return
     */
    @RequestMapping(value = "/page",method = RequestMethod.GET)
    public String getPageAll(Model mv,HttpServletRequest request){
        String parameter = request.getParameter("pageNum");
        Integer pageNum = Integer.valueOf(parameter);
        Integer pageNum1=1;
        System.out.println(pageNum);
        //分页数据
        Page<Employee> pageAll = employeeService.getPageAll(pageNum, 10);
        List<Employee> result = pageAll.getResult();
        for (Employee employee : result) {
            System.out.println("employee-----------"+employee);
        }
        System.out.println("pageNum---------------"+pageNum);
        if(pageNum!=1){
            pageNum1 = pageNum-1;
        }else {
            pageNum1 =1;
        }
        Integer pageNum2 =1;
        if(pageAll.getPages()==pageNum2){
            pageNum2=pageAll.getPages();
        }else {
            pageNum2=pageNum+1;
        }

        List list=new ArrayList();
        for (int i = 0; i < pageAll.getPages(); i++) {
            list.add(i+1);
        }
        mv.addAttribute("pageNum1",pageNum1);
        mv.addAttribute("pageNum2",pageNum2);
        mv.addAttribute("page",list);
        mv.addAttribute("pageAll",pageAll);
        mv.addAttribute("employee",result);
//        mv.addObject("employee",result);
//        mv.setViewName("admin-list");
        return "admin-list";
    }

    /**
     * 条件查询数据
     */
//    @RequestMapping("/getPageByName")
    @ResponseBody
    public ModelAndView getPageByName(ModelAndView mv,String employeeName){
        System.out.println(employeeName);
        Page<Employee> pageByName = employeeService.getPageByName();
        List<Employee> result = pageByName.getResult();
        List<Employee> employee=new ArrayList<>();
        for (Employee employees : result) {
           if(employees.getName().equals(employeeName)){
               employee.add(employees);
           }
        }
        for (Employee employees : employee) {
            System.out.println("employeeName================"+employee);
        }
        mv.addObject("employee",employee);
        mv.setViewName("admin-list");
        return mv;
    }
}
