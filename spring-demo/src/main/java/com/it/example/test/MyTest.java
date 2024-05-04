package com.it.example.test;

import com.it.example.bean.Student;
import com.it.example.bean.User;
import com.it.example.config.MyBeanA;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {

	@Test
	public void test1() {
		AnnotationConfigApplicationContext applicationContext =
				new AnnotationConfigApplicationContext("com.it.example");

		User user = applicationContext.getBean(User.class);
		MyBeanA bean = applicationContext.getBean(MyBeanA.class);

		System.out.println(user);
		System.out.println(bean);

		applicationContext.close();
	}

	@Test
	public void test2() {
		ClassPathXmlApplicationContext applicationContext =
				new ClassPathXmlApplicationContext("spring-demo.xml");

		Student student = applicationContext.getBean("student", Student.class);
		System.out.println(student);

		applicationContext.close();
	}

}
