package com.kairos.server.model;


	import org.springframework.amqp.core.Queue;
	import org.springframework.context.annotation.Bean;
	import org.springframework.context.annotation.Configuration;
	import org.springframework.context.annotation.Profile;

	@Configuration
	public class RabbitReceiverConfiguration  {

	  // Nombre de la cola
	  private String queue = "taskProgress";
	  // nombre del exchange
	  private String exchange = "taskProgress-Exchange";

	  private String routingKey ="routingKey";
	  // nombre del usuario de conexión a la cola
	  private String username="user";

	  // Contraseña del usuario de conexión a la cola
	  private String password = "password";

	  // ip del servidor donde está la cola (localhost) o 127.0.0.1
	  private String host ="localhost";

	  @Bean
	  Queue queue() {
		  return new Queue(queue, true);
	  }

	  @Bean
	  Exchange myExchange() {
		  return ExchangeBuilder.directExchange(exchange).durable(true).build();
	  }

	  @Bean
	  Binding binding() {
		  return BindingBuilder
				  .bind(queue())
				  .to(myExchange())
				  .with(routingKey)
				  .noargs();
	  }

	  @Bean
	  ConnectionFactory connectionFactory() {
		  CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory(host);
		  cachingConnectionFactory.setUsername(username);
		  cachingConnectionFactory.setPassword(password);
		  return cachingConnectionFactory;
	  }

	  @Bean
	  MessageConverter jsonMessageConverter() {
		  return new Jackson2JsonMessageConverter();
	  }

	  @Bean
	  RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
		  final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		  rabbitTemplate.setMessageConverter(jsonMessageConverter());
		  return rabbitTemplate;
	  }

}
