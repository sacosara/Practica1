package com.kairos.server.model;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

@Service
public class RabbitSender {
	
	@Autowired
	private RabbitTemplate template;
	
	@Autowired
	private Queue queue;

	@Autowired
	public RabbitSender(RabbitTemplate template){
		this.template = template;

	}

	
	@Scheduled(fixedDelay = 1000, initialDelay = 500)
	public void send(String msg) {
		this.template.convertAndSend(queue.getName(), msg);
		//System.out.println(" [x] Sent '" + msg + "'");
	}
}
