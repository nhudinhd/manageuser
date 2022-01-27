package com.manager.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.manager.user.common.filter.JwtFilter;

@SpringBootApplication
public class ManagerUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManagerUserApplication.class, args);
	}

}
