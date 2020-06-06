package com.zensar.com.assignmentflowersdemoservice.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.zensar.com.assignmentflowersdemoservice.bean.User;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration
public class UserServiceImplTest {

	@Mock
	UserService userService;
	
	@Test
	void testGetUsers() {
		List<User> Users = new ArrayList<User>();

		Users.add(new User(1, 10, "mock title 1", "abcde 1"));
		Users.add(new User(2, 11, "mock title 2", "abcde 2"));
		Users.add(new User(3, 12, "mock title 3", "abcde 3"));
		Users.add(new User(4, 13, "mock title 2", "abcde 4"));
		Users.add(new User(5, 14, "mock title 3", "abcde 5"));
		when(userService.getUsers()).thenReturn(Users);

		assertEquals(5, userService.getUsers().size());
	}

	@Test
	void testGetUniqueUsers() {
		List<User> uniqueUsers = new ArrayList<User>();
		uniqueUsers.add(new User(1, 10, "mock title 1", "abcde 1"));
		uniqueUsers.add(new User(2, 11, "mock title 2", "abcde 2"));
		uniqueUsers.add(new User(3, 12, "mock title 3", "abcde 3"));
		uniqueUsers.add(new User(4, 13, "mock title 4", "abcde 4"));

		when(userService.getUniqueUsers()).thenReturn(uniqueUsers);

		assertEquals(4, userService.getUniqueUsers().size());
	}

	@Test
	void testUpdateUsersById() {
		List<User> Users = new ArrayList<User>();
		Users.add(new User(1, 10, "mock title 1", "abcde 1"));
		Users.add(new User(2, 11, "mock title 2", "abcde 2"));
		Users.add(new User(3, 12, "mock title 3", "abcde 3"));
		Users.add(new User(4, 13, "mock title 2", "abcde 4"));
		Users.add(new User(5, 14, "mock title 3", "abcde 5"));

		User updatedUsers = new User(4, 13, "1800Flowers", "1800Flowers");

		when(userService.updateUserById(4, "1800Flowers")).thenReturn(updatedUsers);

		equals(("1800Flowers").equals(updatedUsers.getTitle()));
	}

}
