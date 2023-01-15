package com.it.example.test;

import com.it.example.bean.User;
import com.it.example.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Demo1 {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext =
				new AnnotationConfigApplicationContext(AppConfig.class);

		User user = applicationContext.getBean("user", User.class);

		System.out.println(user);

		applicationContext.close();

	}
}
