package com.example.demo.publisher;

 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQProducer {

	
	  @Value("${rabbitmq.queue.name}") private String queuename;
	  
	  @Value("${rabbitmq.exchange.name}") private String exchangename;
	  
	  @Value("${rabbitmq.routing.key}") private String routingKey;
	 
	
		
		  private static final Logger LOGGER =
		  LoggerFactory.getLogger(RabbitMQProducer.class);
		  
		  
		  @Autowired(required = true) private RabbitTemplate rabbitTemplate;
		  
		  
		  
		  
		  public RabbitMQProducer(RabbitTemplate rabbitTemplate) {
		  
		  this.rabbitTemplate = rabbitTemplate; }
		  
		  public void sendMessage(String message) {
		  
		  
		  
		  LOGGER.info(String.format("Message startint to send -> %s", message));
		  
		  for(int i=1;i<=25000; i++) {
		  
		  rabbitTemplate.convertAndSend(exchangename,routingKey,message + ":" + i);
		  
		  }
		  
		  LOGGER.info(String.format("Message sent it -> %s", message));
		  
		  }
		 
	
	
}
