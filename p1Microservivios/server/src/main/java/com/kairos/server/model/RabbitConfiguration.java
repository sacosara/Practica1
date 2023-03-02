package com.kairos.server.model;


	import org.springframework.amqp.core.Queue;
	import org.springframework.context.annotation.Bean;
	import org.springframework.context.annotation.Configuration;
	import org.springframework.context.annotation.Profile;

	@Profile({"server","hello-world"})
	@Configuration
	public class RabbitConfiguration  {

	    @Bean
	    Queue hello() {
	        return new Queue("newTasks");
	    }

	    @Profile("receiver")
	    @Bean
	    RabbitReceiver receiver() {
	        return new RabbitReceiver();
	    }

	    @Profile("sender")
	    @Bean
	    RabbitSender sender() {
	        return new RabbitSender();
	    }

}
