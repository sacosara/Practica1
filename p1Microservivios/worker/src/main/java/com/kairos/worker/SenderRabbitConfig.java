package com.kairos.server.model;


import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile({"worker","hello-world"})
@Configuration
public class RabbitConfiguration  {

    @Bean
    Queue hello() {
        return new Queue("tasksProgress");
    }

    @Profile("sender")
    @Bean
    RabbitSender sender() {
        return new RabbitSender();
    }

}
