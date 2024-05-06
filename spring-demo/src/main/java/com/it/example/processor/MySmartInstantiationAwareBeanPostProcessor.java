package com.it.example.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.SmartInstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Constructor;

@Component
public class MySmartInstantiationAwareBeanPostProcessor implements SmartInstantiationAwareBeanPostProcessor {

	/**
	 * 实例化Bean时，需要选择构造方法（默认无参构造）
	 */
	@Override
	public Constructor<?>[] determineCandidateConstructors(Class<?> beanClass, String beanName) throws BeansException {
		System.out.println("第二步：MySmartInstantiationAwareBeanPostProcessor.determineCandidateConstructors: " + beanName + "=" + beanClass);
		return SmartInstantiationAwareBeanPostProcessor.super.determineCandidateConstructors(beanClass, beanName);
	}

	/**
	 * 出现循环依赖问题时，是否需要返回早期的未赋值的 Bean
	 */
	@Override
	public Object getEarlyBeanReference(Object bean, String beanName) throws BeansException {
		System.out.println("第四步：MySmartInstantiationAwareBeanPostProcessor.getEarlyBeanReference: " + beanName + "=" + bean);
		return SmartInstantiationAwareBeanPostProcessor.super.getEarlyBeanReference(bean, beanName);
	}

}
