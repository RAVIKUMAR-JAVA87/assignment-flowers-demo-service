package com.zensar.com.assignmentflowersdemoservice.repository;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import com.zensar.com.assignmentflowersdemoservice.bean.User;
import com.zensar.com.assignmentflowersdemoservice.exception.RestClientCommunicationException;

@Repository
public class UserRepositoryImpl implements UserRepository{

	private static Logger logger = LoggerFactory.getLogger(UserRepositoryImpl.class);

	
	@Autowired
	RestTemplate restTemplate;
	
	@Value("${rest.client.url}")
	private String restClientURL;
	
	@Override
	public List<User> getUsers() {
		
		try {
			User[] user = restTemplate.getForObject(restClientURL, User[].class);
			return Arrays.asList(user);
		} catch (HttpClientErrorException | HttpServerErrorException errorException) {
			logger.error(String.format("%s %s",
					"Given client API URL is down or temporary unavaliable or Syntax error with API URL",
					errorException.getStackTrace()));
			throw new RestClientCommunicationException(
					"Given client API URL is down or temporary unavaliable or Syntax error with API URL");
		}	
	}
}
