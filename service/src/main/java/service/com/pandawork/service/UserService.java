package com.pandawork.service;

import com.pandawork.common.entity.User;
import com.pandawork.core.common.exception.SSException;

import java.util.List;

/**
 * UserService
 * Created by chant on 2016/3/23.
 */
public interface UserService {
    /**
     * 根据id查User
     * @param id
     * @throws SSException
     */
    public User queryById(int id) throws SSException;
    /**
     * 更新
     * @param user
     * @throws SSException
     */
    public void update(User user) throws SSException;

    /**
     * 用户列表
     * @return
     * @throws SSException
     */
    public List<User> listAll() throws SSException;

    /**
     * 检查用户名是否存在
     * @param userName
     * @return
     * @throws SSException
     */
    public boolean checkUserName(String userName) throws SSException;

    /**
     * 新增用户
     * @return
     * @throws SSException
     */
    public void newUser(User user)throws SSException;

    /**
     * 删除用户
     * @param id
     */
    public boolean delById(int id) throws SSException;

    /**
     *
     * @param userName
     * @param password
     * @return
     * @throws SSException
     */
    public int countByUserNameAndPassword(String userName, String password) throws SSException;

    /**
     *
     * @param userName
     * @return
     * @throws SSException
     */
    public int countByUserName(String userName) throws SSException;

//    /**
//     * 检查登录
//     * @param userName
//     * @param password
//     * @return
//     * @throws SSException
//     */
//    public boolean checkLogin(String userName,String password) throws SSException;

}
