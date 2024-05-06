package com.it.example.processor;

import org.springframework.beans.factory.support.MergedBeanDefinitionPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.stereotype.Component;

@Component
public class MyMergedBeanDefinitionPostProcessor implements MergedBeanDefinitionPostProcessor {

	/**
	 * Spring合并后的 Bean定义可以在这里进行二次修改
	 */
	@Override
	public void postProcessMergedBeanDefinition(RootBeanDefinition beanDefinition, Class<?> beanType, String beanName) {
		System.out.println("第三步：MyMergedBeanDefinitionPostProcessor.Merged: " + beanName + "=" + beanType + "===" + beanDefinition);
	}

	/**
	 * 重置 Bean 定义
	 */
	@Override
	public void resetBeanDefinition(String beanName) {
		System.out.println("MyMergedBeanDefinitionPostProcessor.Reset: " + beanName);
		MergedBeanDefinitionPostProcessor.super.resetBeanDefinition(beanName);
	}
}
