package com.it.example.config;

import com.it.example.bean.MyBeanA;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

@Import(MyBeanA.class)
@ImportResource("classpath:spring-demo.xml")		// 仅支持 XML 和 *.groovy 等文件的解析
@PropertySource("classpath:custom.properties")		// spring 不支持 yml 文件解析，springboot 可以
@Configuration
public class MyDbConfig {

	@Value("${spring.datasource.driver-class-name}")
	private String driverClassName;

	@Value("${spring.datasource.url}")
	private String url;

	@Value("${spring.datasource.username}")
	private String username;

	@Value("${spring.datasource.password}")
	private String password;

	@Override
	public String toString() {
		return "MyDbConfig{" +
				"driverClassName='" + driverClassName + '\'' +
				", url='" + url + '\'' +
				", username='" + username + '\'' +
				", password='" + password + '\'' +
				'}';
	}
}
