package com.flightbooking.controller;

	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.beans.factory.annotation.Value;
	import org.springframework.core.env.Environment;
	import org.springframework.stereotype.Controller;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.ResponseBody;
	//import ch.qos.logback.classic.Logger;


	@Controller
	@ResponseBody
	public class TestController {
		
		@Autowired
		Environment env;
		Logger logger= (Logger) LoggerFactory.getLogger(TestController.class);
		@Value("${app.message}")
		String message;
		
		@Value("${SUCCESS}")
		String message2;
		
		@RequestMapping("/")
		public String index() {
			logger.trace("This is a trace message");
			logger.debug("This is a debug message");
			logger.info("This is an Info message");
			logger.warn("This is a warning message");
			logger.error("This is an error message");
			logger.info(message);
			return "Just for testing";
			
		}
		
		@RequestMapping("/login")
		public void authentication() {
			String name = env.getProperty("username");
			logger.info("Welcome " +name +" " +message2);
		}

	}


