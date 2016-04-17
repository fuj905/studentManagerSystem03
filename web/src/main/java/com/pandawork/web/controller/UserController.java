package com.pandawork.web.controller;

import com.pandawork.common.entity.User;
import com.pandawork.core.common.exception.SSException;
import com.pandawork.core.common.log.LogClerk;
import com.pandawork.core.common.util.CommonUtil;
import com.pandawork.service.UserService;
import com.pandawork.web.spring.AbstractController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.List;

/**
 * description:
 * user: mayuan
 * date: 2016/3/27
 * time: 20:04
 **/
@Controller
@RequestMapping( "/user")
public class UserController extends AbstractController {
    public UserService userService;

    @RequestMapping(value = "/querybyid",method = RequestMethod.POST)
    public String queryById(@RequestParam("id") int id){
        try {
            userService.queryById(id);
            return "userList";
        } catch (SSException e){
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }


    @RequestMapping(value = "/listuser" ,method = RequestMethod.POST)
    public String listUser(Model model) throws SSException {
        try {
            List<User> list= Collections.emptyList();
            list = userService.listAll();
            model.addAttribute("userList", list);
            return "userList";
        }catch(SSException e){
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_FORBIDDEN_PAGE;

        }
    }

//    @RequestMapping(value ="/update",method=RequestMethod.POST)
//    public String update(User user)throws SSException{
//        try{
//            userService.update(user);
//            return "userList";
//        }catch(SSException ee){
//        LogClerk.errLog.error(ee);
//        sendErrMsg(ee.getMessage());
//        return ADMIN_FORBIDDEN_PAGE;
//    }
//    }

    @RequestMapping(value = "/form" ,method = RequestMethod.GET)
    public String toform(){  //将取到的参数返回给form
        return "form";
    }  //打开表单页

//    @RequestMapping(value = "/delete/{id}" ,method = RequestMethod.GET)
//        public String deleteById(@PathVariable("id") String id){
//        try {
//            if (userService.deleteById(id)) {
//                return "redirect:/user/listUser";
//            }
//        } catch (SSException ee ){
//            LogClerk.errLog.error(ee);
//            sendErrMsg(ee.getMessage());
//            return ADMIN_SYS_ERR_PAGE;
//        }
//    }

    @RequestMapping(value="/checkLogin",method=RequestMethod.GET)
    public String checkLogin(User user,@RequestParam("userName")String userName,String password){
        try{
            if(userService.checkUserName(user.getUserName())){
                if(user.getPassword().equals(password)){
                    return "userList";
                }
            }
        }catch (SSException e){
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
        return "message";
    }

    @RequestMapping(value = "/new" ,method = RequestMethod.POST)
    public String newUser(User user, @RequestParam("password2")String password2, Model model){
        try {
            if (!user.getPassword().equals(password2))
            {
                model.addAttribute("message","密码不一致");
                return "form";
            }
            if (userService.checkUserName(user.getUserName()))
            {
                model.addAttribute("message","用户名已经存在");
                return "form";
            }
            user.setPassword(CommonUtil.md5(user.getPassword()));
            userService.newUser(user);
            model.addAttribute("message","success");
            return "message";
        } catch (SSException e){
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }
}
