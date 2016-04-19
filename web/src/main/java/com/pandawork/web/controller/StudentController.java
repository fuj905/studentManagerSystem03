package com.pandawork.web.controller;

import com.pandawork.common.entity.Student;
import com.pandawork.core.common.exception.SSException;
import com.pandawork.core.common.log.LogClerk;
import com.pandawork.web.spring.AbstractController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Collections;
import java.util.List;

/**
 * StudentController
 *
 * @author: mayuan
 * @time: 2015/8/26 16:57
 */
@Controller
@RequestMapping("/student")
public class StudentController extends AbstractController {

    @RequestMapping(value = "/liststudent" ,method = RequestMethod.GET)
    public String studentList(Model model){
        try {
            List<Student> list = Collections.emptyList();
            list=studentService.listAll();
            model.addAttribute("studentList",list);
            return "studentList";
        } catch (SSException e ){
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }

    @RequestMapping(value = "delete" ,method = RequestMethod.GET)
    public String delById(@RequestParam("id")int id){
        try{
            studentService.delById(id);
            return "studentList";
        }
            catch (SSException e){
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }

    @RequestMapping(value ="update",method = RequestMethod.GET)
    public String update(@RequestParam("student") Student student){
        try {
            studentService.update(student);
            return "studentList";
        } catch (SSException e ){
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }

    @RequestMapping(value ="newStudent",method = RequestMethod.GET)
    public String newStudent(@RequestParam("student")Student student){
        try {
            studentService.newStudent(student);
            return "studentList";
        } catch (SSException e ){
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }

//    @RequestMapping(value ="queryStudent",method = RequestMethod.GET)
//    public String queryStudent(@RequestParam("student") Student student){
//        try {
//            studentService.queryStudent(student);
//            return "studentList";
//        } catch (SSException e ){
//            LogClerk.errLog.error(e);
//            sendErrMsg(e.getMessage());
//            return ADMIN_SYS_ERR_PAGE;
//        }
//    }

    @RequestMapping(value="querybyid",method = RequestMethod.POST)
    public String queryById(@RequestParam("id") int id) throws SSException {
        try{
            studentService.queryById(id);
            return "studentList";
        }
        catch (SSException e){
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }


}
