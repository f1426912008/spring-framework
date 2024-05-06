package com.it.example.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class MyInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {

	/**
	 * 实例化Bean之前，需要执行的逻辑
	 */
	@Override
	public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
		System.out.println("第一步：MyInstantiationAwareBeanPostProcessor.Before: " + beanName + "=" + beanClass);
		return InstantiationAwareBeanPostProcessor.super.postProcessBeforeInstantiation(beanClass, beanName);
	}

	/**
	 * 实例化Bean之后，需要执行的逻辑
	 */
	@Override
	public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
		System.out.println("第五步：MyInstantiationAwareBeanPostProcessor.After: " + beanName + "=" + bean);
		return InstantiationAwareBeanPostProcessor.super.postProcessAfterInstantiation(bean, beanName);
	}

	/**
	 * 实例化Bean之后，属性填充之前，如果需要额外的参数，使用 PropertyValues 进行传值
	 */
	@Override
	public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
		System.out.println("第六步：MyInstantiationAwareBeanPostProcessor.Properties: " + beanName + "=" + bean + "===" + pvs);
		return InstantiationAwareBeanPostProcessor.super.postProcessProperties(pvs, bean, beanName);
	}
}
