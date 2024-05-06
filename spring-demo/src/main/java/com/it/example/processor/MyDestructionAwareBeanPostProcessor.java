package com.it.example.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.DestructionAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class MyDestructionAwareBeanPostProcessor implements DestructionAwareBeanPostProcessor {

	/**
	 * 用于Bean销毁时需要执行的逻辑
	 * 例如：@PreDestroy 注解标记的方法，就是当前接口完成的
	 */
	@Override
	public void postProcessBeforeDestruction(Object bean, String beanName) throws BeansException {
		System.out.println("第九步：MyDestructionAwareBeanPostProcessor.Destruction: " + beanName + "=" + bean);
	}

	/**
	 * 控制后置处理器是否执行，返回 true 时将执行销毁的方法
	 */
	@Override
	public boolean requiresDestruction(Object bean) {
		return DestructionAwareBeanPostProcessor.super.requiresDestruction(bean);
	}
}
