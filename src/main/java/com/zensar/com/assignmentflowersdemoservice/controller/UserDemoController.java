package com.zensar.com.assignmentflowersdemoservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.com.assignmentflowersdemoservice.bean.User;
import com.zensar.com.assignmentflowersdemoservice.service.UserService;

@RestController
@RequestMapping("/flowers/api/")
public class UserDemoController {

	@Autowired
	UserService userService;
	
	@GetMapping(value = "/users", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<User>> getUsers(){
	
		List<User> users = userService.getUsers();
		return null == users ? ResponseEntity.noContent().build() : ResponseEntity.ok(users);
	}
	
	@GetMapping(value = "/uniqueUsers", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<User>> getUniqueUsers(){
		List<User> uniqueUsers = userService.getUniqueUsers();
		System.out.println("UniqueUsers" + uniqueUsers.toString());
		return null == uniqueUsers ? ResponseEntity.noContent().build() : ResponseEntity.ok(uniqueUsers);
	}
	
	@PatchMapping(value = "/user/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<User> updateUser(@PathVariable(name="id") int id, @RequestParam String value){
		User updateUser = userService.updateUserById(id, value);
		System.out.println("Update User" + updateUser.toString());
		return null == updateUser ? ResponseEntity.noContent().build() : ResponseEntity.ok(updateUser);
	}
}
