package com.example.demo.publisher;

 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.demo.model.Account;
import com.example.demo.repo.AccountRepo;
import com.example.demo.service.AccountService;

@Service
public class RabbitMQProducer2 {

 
	
	  @Value("${rabbitmq.queue.name}") private String queuename;
	  
	  @Value("${rabbitmq.exchange.name}") private String exchangename;
	  
	  @Value("${rabbitmq.routing.key}") private String routingKey;
	 
	
	private static final Logger LOGGER =  LoggerFactory.getLogger(RabbitMQProducer2.class);
	
	
	
	 
	RabbitTemplate rabbitTemplate;
	  
	  
	  
	  
	  public RabbitMQProducer2(RabbitTemplate rabbitTemplate) {
	  
	  this.rabbitTemplate = rabbitTemplate; }
	  
	  public void sendMessage(String message) {
	  
	  
	  
	  LOGGER.info(String.format("Message startint to send -> %s", message));
	  
	  for(int i=1;i<=250000; i++) {
	  
	  rabbitTemplate.convertAndSend(exchangename,routingKey,message + ":" + i);
	  
	  }
	  
	  LOGGER.info(String.format("Message sent it -> %s", message));
	  
	  }
	  
	  
	  public void sendMessageJson( Account account) {
	  
		  rabbitTemplate.setMessageConverter( new Jackson2JsonMessageConverter() );
		  rabbitTemplate.convertAndSend(exchangename, routingKey, account);
	  
	  // LOGGER.info( "sendMessageJson. All account info sent." );
	  
	  
	  
	  }
	 
	
	
	
}
