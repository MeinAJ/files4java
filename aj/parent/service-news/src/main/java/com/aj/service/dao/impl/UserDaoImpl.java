package com.aj.service.dao.impl;

import com.aj.service.dao.IUserDao;
import com.aj.service.model.MUser;
import org.springframework.stereotype.Repository;

/**
 * this is a class
 *
 * @author Administrator
 * @create 2018-02-17 22:38
 */

@Repository(value = "userDaoImpl")
public class UserDaoImpl extends BaseDao implements IUserDao{

    //登录
    @Override
    public MUser login(MUser mUser) {
        return this.ajDbSqlSessionTemplate.selectOne("UserMapper.getMUser",mUser);
    }

    @Override
    public MUser getMUser(MUser mUser) {
        return this.ajDbSqlSessionTemplate.selectOne("UserMapper.getMUser",mUser);
    }
}
