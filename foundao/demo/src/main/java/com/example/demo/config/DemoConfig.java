package com.example.demo.config;

import com.example.demo.model.WeakPassword;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

//配置类，管理bean
@SpringBootConfiguration
public class DemoConfig {

    @Bean(name = "weakPassword")
    public WeakPassword weakPassword(){
        return new WeakPassword();
    }

}