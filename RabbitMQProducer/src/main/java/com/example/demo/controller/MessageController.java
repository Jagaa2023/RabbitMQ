package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
 
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Account;
import com.example.demo.publisher.RabbitMQProducer;
import com.example.demo.publisher.RabbitMQProducer2;
import com.example.demo.service.AccountService; 

@RestController
@RequestMapping("api/v1")
public class MessageController {
	 
	private static final Logger LOGGER =  LoggerFactory.getLogger(MessageController.class);
	
	
	 
	  private RabbitMQProducer producer;
	  private RabbitMQProducer2 producer2;	  
	  
	  @Autowired
	  AccountService accountservice;
	
	  
	 
	public MessageController(RabbitMQProducer producer, RabbitMQProducer2 producer2) {
		super();
		this.producer = producer;
		this.producer2 = producer2;
	}


	@GetMapping("/publish")
	public ResponseEntity<String> sendMessage(@RequestParam ("message") String message){
		
		//producer.sendMessage(message);

		return ResponseEntity.ok("Message sent to RabbitMQ ...");
		
	}
	
	
	@GetMapping("/publish2")
	public ResponseEntity<String> sendMessage2(@RequestParam ("message") String message){
		
		// producer2.sendMessage(message);

		return ResponseEntity.ok("Message sent to RabbitMQ ...");
		
	}
	
	@GetMapping("/publish3")
	public ResponseEntity<String> sendMessage3( ){
		
 
		
		accountservice.GetAll().forEach(
				
				e->{
					
					producer2.sendMessageJson(e);
					
				});
		
	//	producer2.sendMessageJson(acc);
	 
		// accountsevice.GetAll().forEach( acc->{
		
		 
			
		//});
		
		LOGGER.info(".............................................................. 20,000 data proceeded. ");
		
		
		return ResponseEntity.ok("Message sent to RabbitMQ ... as Json");
		
	}
	
	
	
}
