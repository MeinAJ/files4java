package com.aj.service.service;

import com.aj.service.model.AJResult;
import com.aj.service.model.MUser;
import com.aj.service.utils.AJCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * this is a class
 *
 * @author Administrator
 * @create 2018-04-15 18:41
 */

@SuppressWarnings({ "rawtypes", "static-access", "unchecked" })
@Service("smsService")
public class SmsService extends BaseService {

    @Autowired
    private IFeignJwtService iFeignJwtService;

    @Autowired
    private IFeignRedisService iFeignRedisService;

    //发送验证码
    public String sendSMS(String s) {
        AJResult ajResult = new AJResult();
        return json.toJSONString(ajResult);
    }

    //验证验证码
    public String verifySmsCode(String mUserInfo) {
        AJResult ajResult = new AJResult();
        try {
//            MUser mUser = json.parseObject(mUserInfo, MUser.class);
//
//            Object object = iFeignRedisService.getKey(mUser.getPhone() + "sms" + mUser.getRedisKey());
//            logger.info("redis短信获取的内容是：" + json.toJSONString(object));
//            if (object != null) {
//                MSmsCode mSmsCode = gson.fromJson(gson.toJson(object), MSmsCode.class);
//                String ststus = mSmsCode.getStatus();
//                String smsCode = mSmsCode.getSmsCode();
//                if (smsCode.equals(mCheckCode.getCode())) {
//                    if (ststus.equals("0")) {
//                        map.put("code", "200");
//                        map.put("msg", LanuageHelper.msg(mCheckCode.getLanguage(), "验证成功", "Authentication is successful"));
//                    } else {
//                        map.put("code", "400");
//                        map.put("msg", LanuageHelper.msg(mCheckCode.getLanguage(), "已经使用了该验证码",
//                                "This verification code has been used"));
//                    }
//                } else {
//                    map.put("code", "400");
//                    map.put("msg", LanuageHelper.msg(mCheckCode.getLanguage(), "请输入正确的验证码",
//                            "Please enter the correct verification code"));
//                }
//            } else {
//                map.put("code", "400");
//                map.put("msg", LanuageHelper.msg(mCheckCode.getLanguage(), "请发送验证码",
//                        "Please enter the correct verification code"));
//            }
        } catch (Exception e){
            e.printStackTrace();
            logger.error("验证验证码失败");
            ajResult.setCode(AJCode.FAIL);
            ajResult.setMsg("验证验证码失败");
        }

        return json.toJSONString();
    }
}
