package com.KafkaConsumer.KafkaConsumerExample;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
	public class KafkaConsumerController {
	 
	    @KafkaListener(topics = { "first-type-messages" })
	    public void getTopics(@RequestBody String question) {
	        System.out.println("Kafka event consumed is: " + question);
	    }
	}


