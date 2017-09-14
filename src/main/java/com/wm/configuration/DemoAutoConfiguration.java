package com.wm.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by wm on 2017/8/19.
 */
@Configuration
public class DemoAutoConfiguration {

    @Bean
    public FamilyProperties familyProperties(){
        return new FamilyProperties();
    }
}
