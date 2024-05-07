package com.it.example.publish;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * Spring启动完成后，将发布一个 ContextRefreshedEvent 事件
 */
@Component
public class MyContextRefreshedEventListener implements ApplicationListener<ContextRefreshedEvent> {

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		System.out.println("实现接口订阅事件，spring启动完成：" + event.getSource());
	}

	@EventListener
	public void contextRefreshedEvent(ContextRefreshedEvent event) {
		System.out.println("添加注解订阅事件，spring启动完成：" + event.getSource());
	}

}
