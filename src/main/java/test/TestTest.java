package test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.jikjk.dao.*;
import com.jikjk.entity.Department;
import com.jikjk.entity.Position;
import com.jikjk.entity.Resume;
import com.jikjk.entity.User;
import com.jikjk.service.DepartmentService;
import com.jikjk.service.PositionService;
import com.jikjk.service.UserService;
import com.jikjk.util.Md5;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
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
@Autowired
private UserService userService;

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
public void testD() throws IOException {
    List<Position> positions=positionService.selectById(2);
    System.out.println(positions);
    ObjectMapper mapper = new ObjectMapper();
    String json1=mapper.writeValueAsString(positions);
    System.out.println(json1);
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
    @Test
    public void testpassWord(){
        String password=Md5.md5("1234");
       User user=userService.selectTologin("小红",password);
        System.out.println(user);
    }
} 
