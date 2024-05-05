package com.it.example.publish;

import com.it.example.bean.User;
import org.springframework.context.ApplicationEvent;

import java.io.Serial;

public class MyEvent extends ApplicationEvent {

	@Serial
	private static final long serialVersionUID = 1L;

	public MyEvent(User user) {
		super(user);
	}

}
