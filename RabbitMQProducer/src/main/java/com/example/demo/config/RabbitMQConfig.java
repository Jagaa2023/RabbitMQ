package com.example.demo.config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.repo.AccountRepo;
import com.example.demo.service.AccountService;

//@Configuration
public class RabbitMQConfig {

	@Value("${rabbitmq.queue.name}")
	private String queuename;

	@Value("${rabbitmq.exchange.name}")
	private String exchangename;

	@Value("${rabbitmq.routing.key}")
	private String routingKey;

	@Value("${rabbitmq.queue.name2}")
	private String queuename2;

	@Value("${rabbitmq.exchange.name2}")
	private String exchangename2;

	@Value("${rabbitmq.routing.key2}")
	private String routingKey2;
	
	
	 
	
	 

	
	  @Bean public MessageConverter jsonMessageConverter() { return new
	  Jackson2JsonMessageConverter(); }
	  
	  @Bean
	  public  AmqpTemplate amqpTemplate(ConnectionFactory
			  connectionFactory)
	  {
		  
		  RabbitTemplate  rabbitTemplate = new RabbitTemplate(connectionFactory);
		  rabbitTemplate.setMessageConverter(jsonMessageConverter());
		  
		  return rabbitTemplate;
	  }
	  
	  
	  @Bean public Queue queue() {
	  
	  return new Queue(queuename); }
	  
	  @Bean public Queue queue2() {
	  
	  return new Queue(queuename2, false ); }
	  
	  
	  @Bean public DirectExchange exchange2() {
	  
	  return new DirectExchange(exchangename2);
	  
	  };
	  
	  @Bean public TopicExchange exchange() {
	  
	  return new TopicExchange(exchangename);
	  
	  };
	  
	  
		/*
		 * @Bean public TopicExchange exchange() {
		 * 
		 * return new TopicExchange(exchangename);
		 * 
		 * };
		 */
	  
	
	  @Bean public Binding binding() { return BindingBuilder .bind(queue())
			  .to(exchange()) .with(routingKey); };
			  
	  @Bean public Binding binding2() { return BindingBuilder .bind(queue2())
	  .to(exchange2()) .with(routingKey2); };
	  
	  
	 

	// ConnectionFactory
	// RabbitTemplae
	// RabbitAdmin

}
