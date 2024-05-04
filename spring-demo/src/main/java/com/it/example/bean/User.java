package com.it.example.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class User implements InitializingBean, DisposableBean {

	private String name;

	private Integer age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public void init() {
		System.out.println("User====指定方法完成初始化");
	}

	public void myDestroy() {
		System.out.println("User====指定方法完成销毁对象");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("User====实现接口完成初始化");
	}

	public void destroy() {
		System.out.println("User====实现接口完成销毁");
	}

	@Override
	public String toString() {
		return "User{" +
				"name='" + name + '\'' +
				", age=" + age +
				'}';
	}
}
