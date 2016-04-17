package com.pandawork.common.entity;

import com.pandawork.core.common.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
/**
 * Created by fujia on 2016/3/27.
 * date：${date};
 * time:${time};
 */
@Table(name = "t_student")
@Entity
public class Student extends  AbstractEntity{

    @Id
    public int id;

    @Column (name="student_num")
    private  int studentNum;

    @Column (name="name")
    private  String studentName;

    private  String sex;

    private int grade;

    @Column (name="class_num")
    private int classNum;

    private String college;

    private Date birthday;

    @Column (name="is_good_student")
    private  int goodStudent;

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(Integer studentNum) {
        this.studentNum = studentNum;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getClassNum() {
        return classNum;
    }

    public void setClassNum(int classNum) {
        this.classNum = classNum;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getGoodStudent() {
        return goodStudent;
    }

    public void setGoodStudent(int goodStudent) {
        this.goodStudent = goodStudent;
    }
}
