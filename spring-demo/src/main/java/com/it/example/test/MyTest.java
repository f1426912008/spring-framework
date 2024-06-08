package com.it.example.test;

import com.it.example.bean.DbProperties;
import com.it.example.bean.MyBeanA;
import com.it.example.bean.Student;
import com.it.example.bean.User;
import com.it.example.config.MyConfiguration;
import com.it.example.config.MyPostProcessorConfig;
import com.it.example.factory.MyFactoryBean;
import com.it.example.factory.MyObjectFactory;
import com.it.example.processor.MyYamlPostProcessor;
import com.it.example.publish.MyEvent;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {

	@Test
	public void test1() {
		AnnotationConfigApplicationContext applicationContext =
				new AnnotationConfigApplicationContext("com.it.example");

		User user = applicationContext.getBean(User.class);

		// 测试条件注解以及Scope注解
		MyBeanA bean = applicationContext.getBean(MyBeanA.class);

		System.out.println(user);
		System.out.println(bean);

		applicationContext.close();
	}

	@Test
	public void test2() {
		// 读取XML配置文件创建Bean
		ClassPathXmlApplicationContext applicationContext =
				new ClassPathXmlApplicationContext("spring-demo.xml");

		Student student = applicationContext.getBean("student", Student.class);
		System.out.println(student);

		applicationContext.close();
	}

	@Test
	public void test3() {
		AnnotationConfigApplicationContext applicationContext =
				new AnnotationConfigApplicationContext("com.it.example.lifecycle");

		// MySmartLifeCycle 内部的 isAutoStartup 方法返回true时，将自动执行钩子函数

		// MyLifeCycle 只能手动调用生命周期的钩子函数，如下：
		applicationContext.start();        // 只有isRunning为false可以执行start方法

		applicationContext.stop();        // 只有isRunning为true可以执行stop方法

		applicationContext.close();        // 只有isRunning为true可以执行close方法
	}

	@Test
	public void test4() {
		AnnotationConfigApplicationContext applicationContext =
				new AnnotationConfigApplicationContext("com.it.example.publish");

		User user = new User();
		user.setName("张三");
		user.setAge(18);

		// 发布一个事件，携带自定义的信息对象，后续由监听器触发执行逻辑
		applicationContext.publishEvent(new MyEvent(user));

		applicationContext.close();
	}

	@Test
	public void test5() {
		AnnotationConfigApplicationContext applicationContext =
				new AnnotationConfigApplicationContext(MyPostProcessorConfig.class);

		applicationContext.getBean(MyPostProcessorConfig.class);

		applicationContext.close();
	}

	@Test
	public void test6() {
		AnnotationConfigApplicationContext applicationContext =
				new AnnotationConfigApplicationContext(MyConfiguration.class);

		MyConfiguration config = applicationContext.getBean(MyConfiguration.class);
		System.out.println(config);

		// 使用 @ImportResource("classpath:spring-demo.xml")，引入的Bean
		Student student = applicationContext.getBean(Student.class);
		System.out.println(student);

		// 使用 @Import(MyBeanA.class)，引入的Bean
		MyBeanA bean = applicationContext.getBean(MyBeanA.class);
		System.out.println(bean);

		applicationContext.close();
	}

	@Test
	public void test7() {
		AnnotationConfigApplicationContext applicationContext =
				new AnnotationConfigApplicationContext(MyYamlPostProcessor.class, DbProperties.class);

		// 后置处理器实现读取YML文件
		DbProperties dbProperties = applicationContext.getBean(DbProperties.class);
		System.out.println(dbProperties);

		applicationContext.close();
	}

	@Test
	public void test8() {
		AnnotationConfigApplicationContext applicationContext =
				new AnnotationConfigApplicationContext("com.it.example.factory");

		// FactoryBean 被 Spring 管理时，会被特殊处理，返回的是 FactoryBean 生产的对象
		Student student = (Student) applicationContext.getBean("mfb");
		System.out.println(student);

		// 如果想要获取 FactoryBean 本身，则需要使用 & 和 bean 名称组合
		MyFactoryBean mfb = (MyFactoryBean) applicationContext.getBean("&" + "mfb");
		System.out.println(mfb);


		// ObjectFactory 没有特殊处理，它是一个函数式接口，主要是用作 封装 Bean 的创建过程，
		// 例如：Spring中三级缓存使用它创建对象
		MyObjectFactory mof = (MyObjectFactory) applicationContext.getBean("mof");
		System.out.println(mof.getObject());

		applicationContext.close();
	}

}
