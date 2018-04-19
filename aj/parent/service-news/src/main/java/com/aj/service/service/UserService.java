package com.aj.service.service;

import com.aj.service.dao.impl.UserDaoImpl;
import com.aj.service.model.*;
import com.aj.service.utils.AJCode;
import com.aj.service.utils.RandomUtils;
import com.aj.service.utils.StringUtils;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * this is a user service
 *
 * @author Administrator
 * @create 2018-02-17 22:29
 */
@SuppressWarnings({ "rawtypes", "static-access", "unchecked" })
@Service(value = "userService")
public class UserService extends BaseService{

    @Autowired
    private IFeignJwtService iFeignJwtService;

    @Autowired
    private IFeignRedisService iFeignRedisService;

    //sms服务
    @Resource(name = "smsService")
    private SmsService smsService;


    //user服务
    @Resource(name = "userDaoImpl")
    private UserDaoImpl userDaoImpl;

    //登录
    public String login(String mUserJson) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        AJResult ajResult = new AJResult();
        try {
            MUser mUser = json.parseObject(mUserJson, MUser.class);
            MUser mUser4Result = userDaoImpl.login(mUser);
            if (!(mUser4Result != null && mUser4Result.getName() != null && mUser4Result.getPassword() != null)){
                ajResult.setCode(AJCode.FAIL);
                ajResult.setMsg("登录失败");
                return json.toJSONString(ajResult);
            }
            //登录成功
            //创建jwt
            String uuid = RandomUtils.getUUID();
            String jwt = iFeignJwtService.createJwt(mUser4Result.getName(), mUser4Result.getId(), uuid, "web");
            //存redis
            MLoginRedis mLoginRedis = new MLoginRedis();
            mLoginRedis.setUuId(uuid);
            mLoginRedis.setJwt(jwt);
            mLoginRedis.setUserId(mUser4Result.getId());
            iFeignRedisService.removeKey(mUser4Result.getId()+"web");
            iFeignRedisService.setKey(mUser4Result.getId()+"web",json.toJSONString(mLoginRedis));
            MUser mUserResult = new MUser();
            mUserResult.setJwt(jwt);
            mUserResult.setName(mUser.getName());
            ajResult.setData(mUserResult);
        }catch (Exception e){
            e.printStackTrace();
            logger.error("登录失败");
            ajResult.setCode(AJCode.FAIL);
            ajResult.setMsg("登录失败");
        }
        return json.toJSONString(ajResult);
    }

    //注册
    public String register(String mUserInfo) {
        AJResult ajResult = new AJResult();
        try {
            //1.验证电话号码是否已被注册
            MUser mUser = json.parseObject(mUserInfo, MUser.class);
            mUser = userDaoImpl.getMUser(mUser);
            if (mUser == null || mUser.getId() == 0){
                ajResult.setCode(AJCode.SUCESS_OPERATE);
                ajResult.setMsg("该电话已被注册,请登录!");
                return json.toJSONString(ajResult);
            }
            //未被注册,进行注册,验证验证码
            String result4SMS = smsService.verifySmsCode(json.toJSONString(mUser));



        } catch (Exception e){
            e.printStackTrace();
            logger.error("登录失败");
            ajResult.setCode(AJCode.FAIL);
            ajResult.setMsg("登录失败");
        }
        return json.toJSONString(ajResult);
    }

    //发送验证码
    public String sendSMS(String mUserInfo) {
        AJResult ajResult = new AJResult();
        try {
            MUser mUser = json.parseObject(mUserInfo, MUser.class);
            //获取四位验证码
            String code = RandomUtils.getRandomSMS();
            String phone = mUser.getPhone() + "";
            mUser.setSmsCode(code);
            //检验,3分钟之内只能发送2条验证码
            Object object = iFeignRedisService.getKey(mUser.getPhone() + "sms" + mUser.getRedisKey());
            if (object == null){
                String resultInfo = smsService.sendSMS(json.toJSONString(mUser));
                AJResult ajResult4SMS = json.parseObject(resultInfo, AJResult.class);
                if (ajResult4SMS.getCode().equals(AJCode.SUCCESS)){
                    //发送成功
                    //存入redis
                    SmsCode smsCode = new SmsCode();
                    smsCode.setPhone(mUser.getPhone());
                    smsCode.setRedisKey(mUser.getRedisKey());
                    smsCode.setSmsCode(code);
                    smsCode.setNum(String.valueOf(1));
                    iFeignRedisService.setKeyByMinutes(mUser.getPhone() + "sms" + mUser.getRedisKey(),json.toJSONString(smsCode),3);
                    return json.toJSONString(ajResult);
                }
            } else{
                SmsCode smsCode = json.parseObject(json.toJSONString(object), SmsCode.class);
                if (String.valueOf(2).equals(smsCode.getNum())){
                    ajResult.setCode(AJCode.FAIL);
                    ajResult.setMsg("3分钟内只能发送两次");
                    return json.toJSONString(ajResult);
                } else {
                    //第二次发送验证码
                    String resultInfo = smsService.sendSMS(json.toJSONString(mUser));
                    AJResult ajResult4SMS = json.parseObject(resultInfo, AJResult.class);
                    if (ajResult4SMS.getCode().equals(AJCode.SUCCESS)){
                        //发送成功
                        //存入redis
                        SmsCode smsCode4SecondTime = new SmsCode();
                        smsCode4SecondTime.setPhone(mUser.getPhone());
                        smsCode4SecondTime.setRedisKey(mUser.getRedisKey());
                        smsCode4SecondTime.setSmsCode(code);
                        smsCode4SecondTime.setNum(String.valueOf(2));
                        iFeignRedisService.setKeyByMinutes(mUser.getPhone() + "sms" + mUser.getRedisKey(),json.toJSONString(smsCode4SecondTime),3);
                        return json.toJSONString(ajResult);
                    }
                }
            }
        } catch (Exception e){
            e.printStackTrace();
            logger.error("发送验证码失败");
            ajResult.setCode(AJCode.FAIL);
            ajResult.setMsg("发送验证码失败");
        }
        return null;
    }
}
