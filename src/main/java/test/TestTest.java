

import com.jikjk.dao.UserDao;
import com.jikjk.util.Md5;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/** 
* Test Tester. 
* 
* @author <Authors name> 
* @since <pre>ʮ�� 12, 2018</pre> 
* @version 1.0 
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class TestTest { 
@Autowired
private UserDao userDao;
@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
}
@Test
public void test(){
    System.out.println(userDao.selectByUname("С��"));
    String password= Md5.md5("123");

    System.out.println(userDao.selectTologin("С��",password));
}
} 
