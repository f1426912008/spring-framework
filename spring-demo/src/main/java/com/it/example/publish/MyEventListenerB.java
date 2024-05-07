package com.it.example.publish;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class MyEventListenerB {

	@EventListener
	public void myEvent(MyEvent event) {
		System.out.println("添加注解订阅事件：" + event.getSource());
	}

}
