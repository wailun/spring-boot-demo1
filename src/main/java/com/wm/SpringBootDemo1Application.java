package com.wm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableAutoConfiguration
public class SpringBootDemo1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemo1Application.class, args);
	}
}
