package com.pandawork.test;


import com.pandawork.common.entity.Student;
import com.pandawork.common.entity.User;
import com.pandawork.core.common.exception.SSException;
import com.pandawork.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by chant on 2016/3/26.
 */
public class UserServiceTest extends AbstractTestCase {

    @Autowired
    UserService userService;

    @Test
    public void testQueryById() throws SSException {
        System.out.println(userService.queryById(1).getUserName());
    }

    @Test
    public void testUpdate() throws SSException{
        User user = new User();
        user.setId(2);
        user.setUserName("fujia01");
        user.setPassword("lala");
        userService.update(user);
        System.out.println("12");
    }


        Test
         public void testCheckLogin() throws SSException {
            User user = new User();
            user.setUserName("111");
            user.setPassword("666");
            if(userService.checkLogin(userName,password))
                System.out.print("yyyyyyy");
         }
}
