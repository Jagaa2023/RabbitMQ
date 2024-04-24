package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.publisher.RabbitMQProducer;
import com.example.demo.publisher.RabbitMQProducer2;
import com.example.demo.service.AccountService;

@RestController
public class demoController {

	
	

	@Autowired
	private AccountService accountservice;
	
	 
	  
	  
	/*
	 * public demoController(RabbitMQProducer producer, RabbitMQProducer2 producer2)
	 * { super(); this.producer = producer; this.accountservice = accountservice; }
	 */
	 

		@GetMapping("/test")
		public ResponseEntity<String> sendMessage2( ){
			
			// producer2.sendMessage(message);
			
			accountservice.GetAll();
			
			return ResponseEntity.ok("Message sent to RabbitMQ ...");
			
		}
	 
	 
	
}
