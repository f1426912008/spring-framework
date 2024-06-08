package com.it.example.factory;

import com.it.example.bean.Student;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

@Component("mfb")
public class MyFactoryBean implements FactoryBean<Student> {

	@Override
	public Student getObject() {
		Student student = new Student();
		student.setName("小华");
		student.setAge(25);
		student.setClasses("研一");
		return student;
	}

	@Override
	public Class<?> getObjectType() {
		return Student.class;
	}

}
