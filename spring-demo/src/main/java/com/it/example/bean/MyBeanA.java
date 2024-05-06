package com.it.example.bean;

import com.it.example.condition.MyCondition;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Conditional(MyCondition.class)        // 条件注解判断是否注入容器
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)        // 原型/单例
public class MyBeanA implements InitializingBean, DisposableBean {

	@Autowired
	private User user;

	@Override
	public void destroy() throws Exception {
		// Scope为原型时不调用此方法
		System.out.println("MyBeanA实现接口完成销毁===" + this);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("MyBeanA实现接口完成初始化===" + this);
	}

	@Override
	public String toString() {
		return "MyBeanA{" +
				"user=" + user +
				'}';
	}
}
