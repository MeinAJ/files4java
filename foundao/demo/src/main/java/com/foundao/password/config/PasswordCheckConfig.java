package com.foundao.password.config;

import com.foundao.password.model.WeakPassword;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

//配置类，管理bean
@SpringBootConfiguration
public class PasswordCheckConfig {

    @Bean(name = "weakPassword")
    public WeakPassword weakPassword(){
        return new WeakPassword();
    }

}