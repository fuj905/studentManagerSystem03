package com.pandawork.common.entity;

import com.pandawork.core.common.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * User实体
 * Created by fujia on 2016/3/23.
 */
@Table(name = "t_user")
@Entity
public class User extends AbstractEntity {

    //用户ID
    @Id
    private Integer id;

    //用户登录名
    @Column(name = "user_name")
    private String userName;

    //用户登录密码
    private String password;

    //用户创建日期
    @Column(name = "created_time")
    private Date createdTime;

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
