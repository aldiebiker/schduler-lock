package com.senthil.scheduler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import net.javacrumbs.shedlock.core.SchedulerLock;

@Component

public class Task {
	
	@Autowired
	private UserRepository userRepository;
	
	private static final String HOURS_HUNDRED = "PT100H";

	
	@Scheduled(fixedDelayString = "60000")
	@SchedulerLock(name = "emailSenderLock",   lockAtMostForString = HOURS_HUNDRED)
	public void sayHello() throws InterruptedException {
		List<User> users = userRepository.findAll();
		System.out.println("Hello from instance" + users.toString());
	}

}
