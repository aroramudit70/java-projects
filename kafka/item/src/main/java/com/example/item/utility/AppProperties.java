package com.example.item.utility;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
@Component
@ConfigurationProperties("kafka.topic")
public class AppProperties {

	
	
	private String first;
	
	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}
	
	
}
