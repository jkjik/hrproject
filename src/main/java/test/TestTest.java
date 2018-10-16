package test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.jikjk.dao.*;
import com.jikjk.entity.Department;
import com.jikjk.entity.Position;
import com.jikjk.entity.Resume;
import com.jikjk.service.DepartmentService;
import com.jikjk.service.PositionService;
import com.jikjk.util.Md5;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

/** 
* Test Tester. 
* 
* @author <Authors name> 
* @since <pre>十月 12, 2018</pre> 
* @version 1.0 
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class TestTest { 
@Autowired
private UserDao userDao;
@Autowired
private ResumeDao resumeDao;
@Autowired
private DepartmentDao departmentDao;
@Autowired
private DepartmentService departmentService;
@Autowired
private PositionService positionService;
@Autowired
private PositionDao positionDao;
@Autowired
private MassageResumeDao massageResumeDao;
@Autowired
private SendResumeDao sendResumeDao;

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
}
@Test
public void test(){
    System.out.println(userDao.selectByUname("小黑"));
    String password= Md5.md5("123");

    System.out.println(userDao.selectTologin("小红",password));
    Resume resume=new Resume(0,3,"小红",23,"女","本科","上海复旦","见习会计","222@qq.com","12345678901","无","无","wu",7500);
    resumeDao.insert(resume);
}
@Test
public void testD(){
    List<Position> positions=positionService.selectById(2);
    System.out.println(positions);
    String json=JSON.toJSONString(positions);
    System.out.println(json);
}
    @Test
    public void testP(){
        Date date=new Date(System.currentTimeMillis());
        System.out.println(date);
    }

    @Test
    public void testTime(){
        SimpleDateFormat sf=new SimpleDateFormat("HH:mm:ss");
        Date date=new Date(System.currentTimeMillis());
        String time=sf.format(date);
    }
} 
