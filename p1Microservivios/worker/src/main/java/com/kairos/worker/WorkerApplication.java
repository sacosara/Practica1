package com.example.worker;


import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WorkerApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkerApplication.class, args);
	}

	@Bean
	public RabbitTemplate rabbitTemplate(final ConnectionFactory conFactory){
		final RabbitTemplate rTemplate = new RabbitTemplate(conFactory);
		rTemplate.setMessageConverter(converter());
		return rTemplate;
	}

	@Bean
	public Jackson2JsonMessageConverter converter(){
		return new Jackson2JsonMessageConverter();
	}


}
