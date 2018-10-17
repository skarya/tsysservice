package com.tsys.service;

import java.util.logging.Logger;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class Service2 {

	
	Logger logger= Logger.getGlobal();
	//http://host:port/message?name=XXXXX
	@RequestMapping(path="service2", method=RequestMethod.GET)
	@HystrixCommand(fallbackMethod="backup")
	public String primary() {
		logger.info("Welcome to Webservice Service 2 .....");
		logger.info("received request for2 ....."  );
		return "Actual Plan  "  ;
	}
	
	public String backup() {
		logger.info("backup");
		
		return "backup Plan  "  ;
	}
	
}
