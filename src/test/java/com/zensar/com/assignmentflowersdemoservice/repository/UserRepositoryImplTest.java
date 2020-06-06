package com.zensar.com.assignmentflowersdemoservice.repository;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zensar.com.assignmentflowersdemoservice.AssignmentFlowersDemoServiceApplication;
import com.zensar.com.assignmentflowersdemoservice.bean.User;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AssignmentFlowersDemoServiceApplication.class)
public class UserRepositoryImplTest {

	@Autowired
	UserRepository userRepository;
	
	@Test
	void testGetUsers() {
		List<User> users = userRepository.getUsers();
		assertTrue(!users.isEmpty());
		assertNotNull(users);
	}
}
