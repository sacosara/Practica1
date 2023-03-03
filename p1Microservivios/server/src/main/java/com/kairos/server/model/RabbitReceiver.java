package com.kairos.server.model;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@Service
public class RabbitReceiver {

    private ObjectMapper objectMapper = new ObjectMapper();

	@RabbitListener(queues = "tasksProgress")
    public void receive(String in) {
        TaskResponse taskResponse = objectMapper.convertValue(in,TaskResponse.class);
        TaskManager.storeTask(taskResponse);
        System.out.println(" [x] Received '" + in + "'");
    }

}
