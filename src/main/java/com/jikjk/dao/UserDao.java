package com.jikjk.dao;

import com.jikjk.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by lenovo on 2018/10/11.
 */
@Repository
public interface UserDao {
    public void insert(User user);
    public User selectByUname(String uName);
    public User selectTologin(@Param("uName")String uName, @Param("uPassword") String uPassword);
}
