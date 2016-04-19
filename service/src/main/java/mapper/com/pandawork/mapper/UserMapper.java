package com.pandawork.mapper;

import com.pandawork.common.entity.User;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/*
 **
 * UserMapper
 *  Created by chant on 2016/3/23.
 */

public interface UserMapper {
    /**
     * 根据id查User
     * @param id
     * @return
     * @throws Exception
     */
    public User queryById(@Param("id") int id) throws Exception;

    /**
     * 检查userName和password是否配对？
     * @param userName
     * @param password
     * @return
     * @throws Exception
     */
    public Integer countByUserNameAndPassword(@Param("userName") String userName, @Param("password") String password) throws Exception;

    /**
     * 检查用户名是否存在
     * @Param userName
     *
     * @throws Exception
     */
    public boolean checkUserName(@Param("userName")String userName)throws Exception;

    /**
     * 用户列表
     * @return
     * @throws Exception
     */
    public List<User> listAll() throws Exception;

    /**
     * 新增用户
     *@Param userName
     *@Param password
     *@throws Exception
     */
    public void newUser(@Param("userName")String userName,@Param("password")String password)throws Exception;

    /**
     * 删除用户
     *@Param userName
     *@Param password
     *@throws Exception
     */
    public void delById(@Param("id")int id)throws Exception;

    /**
     * 更新
     * @param user
     * @throws Exception
     */
    public void update(@Param("user") User user) throws Exception;

    /**
     *
     * @param userName
     * @return
     * @throws Exception
     */
    public Integer countByUserName(@Param("userName") String userName) throws Exception;
}