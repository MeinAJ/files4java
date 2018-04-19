package com.aj.service.service;

import com.aj.service.model.MJwt;
import com.aj.service.model.MSecret;
import com.aj.service.model.MSub;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Service;

/**
 * @author Administrator
 * @create 2018-02-19 21:11
 */

@Service(value = "jwtService")
public class JwtService extends BaseService {

    /**
     * 解析jwt
     * @param jwt
     * @return
     */
    public String authJwt(String jwt) {
        MSecret mSecret = new MSecret();
        Claims claims = Jwts.parser().setSigningKey(mSecret.getSecret()).parseClaimsJws(jwt).getBody();
        MJwt mJwt = json.parseObject(json.toJSONString(claims),MJwt.class);
        MSub mSub = json.parseObject(json.toJSONString(mJwt.getSub()),MSub.class);
        return null;
    }
}
