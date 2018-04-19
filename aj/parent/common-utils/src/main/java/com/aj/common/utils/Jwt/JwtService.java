package com.aj.common.utils.Jwt;

import com.aj.common.utils.model.MJwt;
import com.aj.common.utils.model.MLoginRedis;
import com.aj.common.utils.model.MSecret;
import com.aj.common.utils.model.MSub;
import com.aj.common.utils.redis.RedisService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

/**
 * this
 *
 * @author Administrator
 * @create 2018-03-01 12:35
 */

@SuppressWarnings("static-access")
@Service("jwtService")
public class JwtService extends BaseService{

    @Resource(name = "redisService")
    private RedisService redisService;

    private static MSecret mSecret = new MSecret();


    /**
     * 创建jwt
     * @return
     */
    public String createJwt(String userName,Long userId,String uuid,String agent){
        try {
            //秘钥
//            String secret = mSecret.getSecret();
            SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
            //携带的信息
            MSub mSub = new MSub();
            mSub.setId(userId);
            mSub.setUserName(userName);
            mSub.setAgent(agent);
            JwtBuilder jwtBuilder = Jwts.builder()
                    .signWith(signatureAlgorithm, "secret")
                    .setSubject(json.toJSONString(mSub))
                    .setId(uuid)
                    .setExpiration(null);
            String compact = jwtBuilder.compact();
            System.out.println("jwt"+compact);
            return compact;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 解析jwt
     * @param jwt
     * @return
     */
    public String authJwt(String jwt){
        try {
            String parseJwt = parseJwt(jwt);
            MJwt mJwt = json.parseObject(parseJwt, MJwt.class);
            MSub mSub = json.parseObject(mJwt.getSub(), MSub.class);
            //判断请求端
            String agent = mSub.getAgent();
            String key = "";
            if (agent == null || "".equals(agent)){
                key = mSub.getId().toString();
            } else {
                key = mSub.getId().toString() + agent;
            }
            //获取缓存中的jwt
            Object object = redisService.getKey(key);
            MLoginRedis mLoginRedis = json.parseObject(json.toJSONString(object), MLoginRedis.class);
            if (mLoginRedis.getUuId().equals(mJwt.getJti())){
                //正确
                return mSub.getId().toString();
            } else {
                return "";
            }
        } catch (Exception e){
            e.printStackTrace();
            return "";
        }
    }

    private String parseJwt(String jwt){
        String secret = mSecret.getSecret();
        Claims body = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJwt(jwt)
                .getBody();
        return json.toJSONString(body);
    }
}
