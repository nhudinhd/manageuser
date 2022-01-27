package com.manager.user.config;

import javax.activation.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class DatabaseConfig {

	@Value("${config.datasource.url}")
	private String databaseUrl;
	@Value("${config.datasource.username}")
	private String userName;
	@Value("${config.datasource.password}")
	private String password;
	@Value("${config.datasource.driverClassName}")
	private String driverClassname;
	
//	public DataSource dataSource() {
//		HikariConfig hikariConfig = new HikariConfig();
//		hikariConfig.setDriverClassName(driverClassname);
//		hikariConfig.setUsername(userName);
//		hikariConfig.setPassword(password);
//		hikariConfig.setJdbcUrl(databaseUrl);
//		return new  HikariDataSource(hikariConfig;
//		
//	}
	

}
