package com.it.example.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {

	/**
	 * 获取到 Bean工厂类，修改容器中的配置/Bean定义
	 */
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("MyBeanDefinitionRegistry.BeanFactory: " + beanFactory);
	}

	/**
	 * 此方法是比上述的 postProcessBeanFactory() 更为早期的扩展点
	 * 获取到Bean定义的注册器，可以在这里注册自己的 Bean定义
	 */
	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		System.out.println("MyBeanDefinitionRegistry.BeanDefinitionRegistry: " + registry);
	}

}
