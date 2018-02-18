package com.aj.service.dao;

import com.aj.service.model.MUser;

public interface IUserDao {

    //登录
    MUser login(MUser mUser);
}
