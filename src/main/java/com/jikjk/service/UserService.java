package com.jikjk.service;

import com.jikjk.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * Created by lenovo on 2018/10/11.
 */
public interface UserService {
    public void insert(User user);
    public User selectByUname(String uName);
    public User selectTologin(String uName,String uPassword);
    public void updateStatue(int uId,int status);
}
