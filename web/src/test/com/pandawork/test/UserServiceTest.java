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

    @Test
    public void testListAll() throws SSException{
        System.out.print(userService.listAll());
    }

    @Test
    public void testCountByUserName() throws SSException{
        User user = new User();
        user.setUserName("fujia");
        userService.countByUserName(user.getUserName());
        System.out.println("lalala");
    }

    @Test
    public void testCheckUserName() throws SSException{
        User user = new User();
        user.setUserName("fujia");
        if(userService.checkUserName(user.getUserName())){
            System.out.println("userName");
        }
    }

    @Test
    public void testNewUser() throws SSException{
        User user = new User();
        user.setUserName("fujing");
        user.setPassword("0407");
        user.setId(222);
        userService.newUser(user);
        System.out.println("成功注册");
    }

    @Test
    public void testDelById() throws SSException{
        User user = new User();
        user.setId(3);
        userService.delById(user.getId());
        System.out.println("16");
    }

    @Test
    public void testCountByUserNameAndPassword() throws SSException{
        User user = new User();
        user.setUserName("fujia");
        user.setPassword("fujia");
        userService.countByUserNameAndPassword(user.getUserName(),user.getPassword());
        System.out.println("lalala");
    }

//    @Test
//    public void testCheckLogin() throws SSException{
//        User user = new User();
//        user.setUserName("fu");
//        user.setPassword("fu");
//        userService.checkLogin(user.getUserName(),user.getPassword());
//        System.out.println("aa");
//    }


}
