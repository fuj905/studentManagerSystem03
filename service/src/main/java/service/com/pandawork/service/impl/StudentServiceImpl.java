package com.pandawork.service.impl;

import com.pandawork.common.entity.Student;
import com.pandawork.common.utils.NFException;
import com.pandawork.core.common.exception.SSException;
import com.pandawork.core.common.log.LogClerk;
import com.pandawork.core.common.util.Assert;
import com.pandawork.core.framework.dao.CommonDao;
import com.pandawork.mapper.StudentMapper;
import com.pandawork.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 学生管理系统
 * studentService的实现
 * Created by fujia on 2016/3/28.
 */
@Service("studentService")
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentMapper studentMapper;

    @Autowired
    @Qualifier("commonDao")//commonDao别名
    protected CommonDao commonDao;

    @Override
    public List<Student> listAll() throws SSException {
        List<Student> studentList;
        try {
        studentList = studentMapper.listAll();
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.ListStudentAll, e);
        }
        return studentList;
    }

    @Override
    public int countAll() throws SSException {
        int count;
        try {
            count = studentMapper.countAll();
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.CountAll, e);
        }
        return count;
    }


    @Override
    public void newStudent(Student student) throws SSException {
        if (Assert.isNull(student)) {
            return ;
        }
        Assert.lessOrEqualZero(student.getStudentNum(), NFException.StudentNumLessOrEqualZero);
        Assert.isNotNull(student.getStudentName(), NFException.StudentNameNotNull);
        Assert.isNotNull(student.getSex(),NFException.SexNotNull);
        Assert.lessOrEqualZero(student.getGrade(), NFException.GradeLessOrEqualZero);
        Assert.lessOrEqualZero(student.getClassNum(), NFException.ClassNumLessOrEqualZero);
        Assert.isNotNull(student.getCollege(),NFException.CollegeNotNull);
        Assert.isNotNull(student.getBirthday(), NFException.BirthdayNotNull);
        Assert.isNotNull(student.getGoodStudent(),NFException.GoodStudentNotNull);
        try {
            studentMapper.newStudent(student);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.SystemException, e);
        }
    }

    @Override
    public boolean delById(int id) throws SSException {
        if (Assert.lessOrEqualZero(id)) {
            return false;
        }
        try {
            studentMapper.delById(id);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.DelStudentNull, e);
        }
        return false;
    }

    @Override
    public void update(Student student) throws SSException {
        if (Assert.isNotNull(student))
            return;
        Assert.lessOrEqualZero(student.getStudentNum(), NFException.StudentNumLessOrEqualZero);
        Assert.isNotNull(student.getStudentName(), NFException.StudentNameNotNull);
        Assert.isNotNull(student.getSex(),NFException.SexNotNull);
        Assert.lessOrEqualZero(student.getGrade(), NFException.GradeLessOrEqualZero);
        Assert.lessOrEqualZero(student.getClassNum(), NFException.ClassNumLessOrEqualZero);
        Assert.isNotNull(student.getCollege(),NFException.CollegeNotNull);
        Assert.isNotNull(student.getBirthday(), NFException.BirthdayNotNull);
        Assert.isNotNull(student.getGoodStudent(),NFException.GoodStudentNotNull);
        try {
//            student.setId(student.getId());
//            student.setStudentNum(student.getClassNum());
//            student.setStudentName(student.getStudentName());
//            student.setSex(student.getSex());
//            student.setGrade(student.getGrade());
//            student.setClassNum(student.getStudentNum());
//            student.setCollege(student.getCollege());
//            student.setBirthday(student.getBirthday());
//            student.setGoodStudent(student.getGoodStudent());
            studentMapper.update(student);
        } catch(Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.UpdateStudentFailed, e);
        }
    }

//    @Override
//    public Student queryStudent(Student student) throws SSException {
//
//        try {
//            return studentMapper.queryStudent(student);
//        } catch (Exception e) {
//            LogClerk.errLog.error(e);
//            throw SSException.get(NFException.QueryStudentFailed, e);
//        }
//    }

    public Student queryById(int id) throws SSException {
        if (Assert.lessOrEqualZero(id)) {
            return null;
        }
        try {
            studentMapper.queryById(id);
        } catch(Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.UpdateStudentByIdFailed, e);
        }
        return null;
    }

    @Override
    public Student queryByName(String studentName) throws SSException {
        if (! Assert.isNull(studentName)) {
        return null;
        }
        try {
            studentMapper.queryByName(studentName);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.QueryByNameFailed, e);
        }
        return null;
    }
}
