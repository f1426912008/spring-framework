package com.it.example.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

	/**
	 * 用于在实例化Bean后的 初始化操作前 需要执行的逻辑，
	 * 例如：@PostConstruct 标记的初始化方法，依赖此方法实现
	 */
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("第七步：MyBeanPostProcessor.Before：" + beanName + "=" + bean);
		return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
	}

	/**
	 * 用于在实例化Bean后的 初始化操作后 需要执行的逻辑，
	 */
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("第八步：MyBeanPostProcessor.After：" + beanName + "=" + bean);
		return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
	}

}
