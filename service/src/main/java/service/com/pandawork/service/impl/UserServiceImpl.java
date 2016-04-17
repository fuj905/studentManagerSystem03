package com.pandawork.service.impl;

import com.pandawork.common.entity.User;
import com.pandawork.common.utils.NFException;
import com.pandawork.core.common.exception.SSException;
import com.pandawork.core.common.log.LogClerk;
import com.pandawork.core.common.util.Assert;
import com.pandawork.core.common.util.CommonUtil;
import com.pandawork.core.framework.dao.CommonDao;
import com.pandawork.mapper.UserMapper;
import com.pandawork.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fujia on 2016/3/28.
 * date：${date};
 * time:${time};
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Autowired
    @Qualifier("commonDao")//commonDao别名
    protected CommonDao commonDao;

    @Override
    public User queryById(int id) throws SSException {
        if (Assert.lessOrEqualZero(id)) {
            return null;
        }
        try {
            return userMapper.queryById(id);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.SystemException,e);
        }
    }

    @Override
    public void update(User user) throws SSException {
        if (Assert.isNotNull( user ))
            return;
        Assert.isNotNull( user.getUserName(), NFException.UserNameNotNull );
        Assert.isNotNull( user.getPassword(), NFException.PasswordNotNull );
        try {
            userMapper.update( user );
        } catch (Exception e) {
            LogClerk.errLog.error( e );
            throw SSException.get( NFException.SystemException, e );
        }
    }

    @Override
    public boolean checkLogin(String userName, String password) throws SSException {
        if (Assert.isNull( userName ) || Assert.isNull( password )) {
            return false;
        }
        try {
            password = CommonUtil.md5( password );
            return userMapper.countByUserNameAndPassword( userName, password ) >= 1 ? true : false;
        } catch (Exception e) {
            LogClerk.errLog.error( e );
            throw SSException.get( NFException.SystemException, e );
        }
    }

    @Override
    public List<User> listAll() throws SSException {
        try {
            return userMapper.listAll();
        } catch (Exception e) {
            LogClerk.errLog.error( e );
            throw SSException.get( NFException.SystemException, e );
        }
    }

    @Override
    public boolean checkUserName(String userName) throws SSException {
        try {
            return userMapper.countByUserName(userName) >= 1 ? true : false;
        } catch (Exception e) {
            LogClerk.errLog.error( e );
            throw SSException.get( NFException.SystemException, e );
        }
    }

    @Override
    public void newUser(User user) throws SSException {
        if (Assert.isNotNull( user )) {
            return;
        }
        //判断用户名与密码是否为空
        Assert.isNotNull( user.getUserName(), NFException.UserNameNotNull );
        Assert.isNotNull( user.getPassword(), NFException.PasswordNotNull );
        try {
            user.setPassword( CommonUtil.md5( user.getPassword() ) );
            userMapper.newUser( "userName", "password" );
        } catch (Exception e) {
            LogClerk.errLog.error( e );
            throw SSException.get( NFException.SystemException, e );
        }
    }

    @Override
    public boolean delById(int id) throws SSException {
        if (Assert.lessOrEqualZero( id )) {
            return false;
        }
        try {
            userMapper.delById( id );
        } catch (Exception e) {
            LogClerk.errLog.error( e );
            throw SSException.get( NFException.SystemException, e );
        }
        return false;
    }

    @Override
    public int countByUserNameAndPassword(String userName, String password) throws SSException {
        if (Assert.isNull( userName ) && Assert.isNotNull( password )) {
            return 0;
        }
        try {
            password = CommonUtil.md5( password );
            return userMapper.countByUserNameAndPassword( userName, password );
        } catch (Exception e) {
            LogClerk.errLog.error( e );
            throw SSException.get( NFException.SystemException, e );
        }
    }

    @Override
    public int countByUserName(String userName) throws SSException {
        if (Assert.isNull( userName )) {
            return 0;
        }
        try {
            return userMapper.countByUserName(userName);
        } catch (Exception e) {
            LogClerk.errLog.error( e );
            throw SSException.get( NFException.SystemException, e );
        }
    }
}
