package com.it.example.test;

import com.it.example.bean.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo2 {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-demo.xml");
		Student student = applicationContext.getBean("student", Student.class);
		System.out.println(student);
	}
}
