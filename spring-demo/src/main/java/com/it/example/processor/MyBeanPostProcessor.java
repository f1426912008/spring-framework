package com.it.example.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("第七步：MyBeanPostProcessor.Before：" + beanName + "=" + bean);
		return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("第八步：MyBeanPostProcessor.After：" + beanName + "=" + bean);
		return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
	}

}
