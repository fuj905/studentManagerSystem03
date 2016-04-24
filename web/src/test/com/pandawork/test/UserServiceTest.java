package com.pandawork.test;

import com.pandawork.common.entity.User;
import com.pandawork.core.common.exception.SSException;
import com.pandawork.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 学生管理系统
 * 测试service页面
 * userService
 * Created by fujia on 2016/3/26.
 */
public class UserServiceTest extends AbstractTestCase {

    @Autowired
    UserService userService;

    //测试根据ID查询用户名
    @Test
    public void testQueryById() throws SSException {
        System.out.println(userService.queryById(1).getUserName());
    }

    //测试更新用户
    @Test
    public void testUpdate() throws SSException{
        User user = new User();
        user.setId(2);
        user.setUserName("fujia01");
        user.setPassword("la");
        userService.update(user);
        System.out.println("12");
}

    //测试查询用户列表
    @Test
    public void testListAll() throws SSException{
        System.out.print(userService.listAll());
    }

    //测试判断用户名是否存在
    @Test
    public void testCountByUserName() throws SSException{
        User user = new User();
        user.setUserName("fujia");
        userService.countByUserName(user.getUserName());
        System.out.println("lalala");
    }

    //测试检查用户名
    @Test
    public void testCheckUserName() throws SSException{
        User user = new User();
        user.setUserName("fujia");
        if(userService.checkUserName(user.getUserName())){
            System.out.println("userName");
        }
    }

    //测试新增用户
    @Test
    public void testNewUser() throws SSException{
        User user = new User();
        user.setUserName("fujing");
        user.setPassword("0407");
        user.setId(4);
        userService.newUser(user);
        System.out.println("成功注册");
    }

    //测试根据ID删除用户
    @Test
    public void testDelById() throws SSException{
        User user = new User();
        user.setId(3);
        userService.delById(user.getId());
        System.out.println("16");
    }

    //测试判断用户名与密码是否匹配
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
