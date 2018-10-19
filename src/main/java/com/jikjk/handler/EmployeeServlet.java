package com.jikjk.handler;

import com.jikjk.dao.EmployeeDao;
import com.jikjk.entity.CreateCultivate;
import com.jikjk.entity.Department;
import com.jikjk.entity.Employee;
import com.jikjk.entity.Position;
import com.jikjk.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by lenovo on 2018/10/16.
 */
@RequestMapping("emp")
@Controller
public class EmployeeServlet {
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private UserService userServiceImpl;
    @Autowired
    private DepartmentService departmentServiceImpl;
    @Autowired
    private PositionService positionServiceImpl;
    @Autowired
    private ResumeService resumeServiceImpl;
    @Autowired
    private AdministratorService admServiceImpl;
    @Autowired
    private SendResumeService sendResumeServiceImpl;
    @Autowired
    private MassageResumeService massageResumeServiceImpl;
    @Autowired
    private InviteJobService inviteJobServiceImpl;
    @Autowired
    private InterviewService interviewServiceImpl;
    @Autowired
    private EmployeeService employeeServiceImpl;
    @Autowired
    private CreateCultivateService createCultivateServiceImpl;

    @InitBinder
    public void initBinder(ServletRequestDataBinder binder){
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"),
                true));
    }

    /**
     * 返回用户主页
     * @return
     */
    @RequestMapping("gotoEmpPage")
    public String gotoEmpPage(){
        return "empPage";
    }

    /**
     * 查看部门信息
     * @return
     */
    @RequestMapping("lookDuty")
    public String lookDuty(ModelMap map){
        List<Department> departments=departmentServiceImpl.selectAll();
        map.addAttribute("departments",departments);
        return "empLookingDuty";
    }

    /**
     * 查看职位
     * @param request
     * @param map
     * @param session
     * @return
     */
    @RequestMapping("getPosition")
    public String getPosition(HttpServletRequest request,ModelMap map,HttpSession session){
        int dId=0;
        try {
            dId=Integer.valueOf(request.getParameter("dId"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        System.out.println(dId);
        Employee employee= (Employee) session.getAttribute("employee");
        //查看本部门员工
        if(employee.getdId()==dId){
            List<Employee> employees=employeeServiceImpl.selectEmployee(employee.getdId());
            System.out.println(employees);
            map.addAttribute("employees",employees);
        }
        List<Position> positions= positionServiceImpl.selectById(dId);
        map.addAttribute("positions",positions);
        //部门信息
        List<Department> departments=departmentServiceImpl.selectAll();
        map.addAttribute("departments",departments);
        return "empLookingDuty";
    }

    /**
     * 查看个人信息
     * @param session
     * @param map
     * @return
     */
    @RequestMapping("lookingYourself")
    public String lookingYourself(HttpSession session,ModelMap map){
        Employee employee= (Employee) session.getAttribute("employee");
        map.addAttribute("employee",employee);
        return "empYourself";
    }

    /**
     * 查看培训通知
     * @param map
     * @param session
     * @return
     */
    @RequestMapping("lookCultivate")
    public String lookCultivate(ModelMap map,HttpSession session){
        Employee employee= (Employee) session.getAttribute("employee");
        String cDuty=departmentServiceImpl.selectNameByDid(employee.getdId());
        List<CreateCultivate> createCultivate=createCultivateServiceImpl.selectByDuty(cDuty);
        map.addAttribute("createCultivate",createCultivate);
        return "empLookingCultivate";
    }

}
