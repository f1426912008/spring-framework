package com.it.example.lifecycle;

import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Component;

@Component
public class MySmartLifeCycle implements SmartLifecycle {

	private final int orderId = 1;
	private boolean isRunning = false;

	/**
	 * 当前执行的序号
	 *
	 * @return
	 */
	@Override
	public int getPhase() {
		return orderId;
	}

	@Override
	public void start() {
		isRunning = true;
		System.out.println("MySmartLifeCycle: 开始执行，orderId = " + orderId);
	}

	@Override
	public void stop() {
		isRunning = false;
		System.out.println("MySmartLifeCycle: 停止执行，orderId = " + orderId);
	}

	@Override
	public boolean isRunning() {
		return isRunning;
	}
}
