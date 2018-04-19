package com.aj.common.utils.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * this is a class for jwt
 *
 * @author Administrator
 * @create 2018-02-22 22:17
 */

@Component
@ConfigurationProperties(prefix = "key")
@PropertySource("classpath:secret.properties")
public class MSecret {

    //秘钥
    private String secret;

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }
}
