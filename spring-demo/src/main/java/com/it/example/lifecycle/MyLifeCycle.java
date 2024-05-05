package com.it.example.lifecycle;

import org.springframework.context.Lifecycle;
import org.springframework.stereotype.Component;

@Component
public class MyLifeCycle implements Lifecycle {

	private boolean isRunning = false;

	@Override
	public void start() {
		isRunning = true;
		System.out.println("MyLifeCycle: 开始执行");
	}

	@Override
	public void stop() {
		isRunning = false;
		System.out.println("MyLifeCycle: 停止执行");
	}

	@Override
	public boolean isRunning() {
		return isRunning;
	}
}
