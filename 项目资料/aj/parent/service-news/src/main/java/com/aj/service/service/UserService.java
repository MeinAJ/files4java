package com.aj.service.service;

import com.aj.service.dao.impl.UserDaoImpl;
import com.aj.service.model.AJResult;
import com.aj.service.model.MUser;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * this is a user service
 *
 * @author Administrator
 * @create 2018-02-17 22:29
 */
@SuppressWarnings("static-access")
@Service(value = "userService")
public class UserService extends BaseService{

    //user服务
    @Resource(name = "userDaoImpl")
    private UserDaoImpl userDaoImpl;

    //登录
    public String login(String mUserJson) {
        AJResult ajResult = new AJResult();
        try {
            MUser mUser = json.parseObject(mUserJson, MUser.class);
            MUser mUser4Result = userDaoImpl.login(mUser);
            if (!(mUser4Result != null && mUser4Result.getName() != null && mUser4Result.getPassword() != null)){
                ajResult.setCode("400");
                ajResult.setMsg("登录失败");
                return json.toJSONString(ajResult);
            }
            ajResult.setData(mUser4Result);
        }catch (Exception e){
            e.printStackTrace();
            logger.error("登录失败");
            ajResult.setCode("400");
            ajResult.setMsg("登录失败");
            return json.toJSONString(ajResult);
        }
        return json.toJSONString(ajResult);
    }
}
