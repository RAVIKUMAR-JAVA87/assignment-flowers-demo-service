package com.zensar.com.assignmentflowersdemoservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zensar.com.assignmentflowersdemoservice.bean.User;
import com.zensar.com.assignmentflowersdemoservice.service.UserService;

@SpringBootApplication
public class AssignmentFlowersDemoServiceApplication implements CommandLineRunner {

	@Autowired
	UserService userService;
	
	public static void main(String[] args) {
		SpringApplication.run(AssignmentFlowersDemoServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		int id = 4;
		String value = "1800Flowers";
		
		User user = userService.updateUserById(id, value);
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonData = mapper.writeValueAsString(user);
		
		System.out.println("Modified json data" + jsonData);
	}
	
	

}
