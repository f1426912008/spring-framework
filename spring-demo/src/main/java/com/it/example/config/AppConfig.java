package com.it.example.config;

import com.it.example.bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	@Bean(name = "user", initMethod = "init", destroyMethod = "myDestroy")
	public User getUser() {
		User user = new User();
		user.setName("俺叫焦恩俊");
		user.setAge(23);
		return user;
	}

}
