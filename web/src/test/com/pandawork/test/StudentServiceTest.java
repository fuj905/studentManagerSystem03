package com.pandawork.test;


import com.pandawork.common.entity.Student;
import com.pandawork.core.common.exception.SSException;
import com.pandawork.service.StudentService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by chant on 2016/3/26.
 */
public class StudentServiceTest extends AbstractTestCase {

    @Autowired
    StudentService studentService;

    @Test
    public void testNewStudent() throws SSException {

        Student student = new Student();
        student.setStudentName("fujia");
        student.setClassNum(2);
        System.out.println("13");
    }

    @Test
    public void testListAll() throws SSException{
        System.out.print(studentService.listAll());
    }

    @Test
    public void testCountAll() throws SSException{
        studentService.countAll();
        System.out.println("11");
    }

    @Test
    public void testDelById() throws SSException{
        Student student = new Student();
        student.setId(5);
        studentService.delById(student.getId());
        System.out.println("16");
    }

    @Test
    public void testUpdate() throws SSException{
        Student student = new Student();
        student.setId(10);
        student.setClassNum(33);
        student.setCollege("艺术");
        student.setStudentName("邱兰");
        studentService.update(student);
        System.out.println("12");
    }

    @Test
    public void testQueryById() throws SSException {
//        Student student = new Student();
//        student.setId(10);
        //studentService.queryById(2);
        System.out.println(studentService.queryById(2).getStudentName());
    }


}
