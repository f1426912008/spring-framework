package com.it.example.factory;

import com.it.example.bean.Student;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.stereotype.Component;

@Component("mof")
public class MyObjectFactory implements ObjectFactory<Student> {

	@Override
	public Student getObject() throws BeansException {
		Student student = new Student();
		student.setName("小伶");
		student.setAge(26);
		student.setClasses("研二");
		return student;
	}

}
