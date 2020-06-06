package com.zensar.com.assignmentflowersdemoservice.service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.com.assignmentflowersdemoservice.bean.User;
import com.zensar.com.assignmentflowersdemoservice.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public List<User> getUsers() {
		
		List<User> userlist = userRepository.getUsers();
		return userlist;
	}

	@Override
	public List<User> getUniqueUsers() {
		List<User> uniqueUsers = userRepository.getUsers();
		List<User> distinctElements = uniqueUsers.stream()
                .filter( distinctByKey(p -> p.getUserId()) )
                .collect( Collectors.toList() );
			//System.out.println(distinctElements.toString());
			return distinctElements;
	}

	//Utility function
    private static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) 
    {
        Map<Object, Boolean> map = new ConcurrentHashMap<>();
        return t -> map.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }
	
	@Override
	public User updateUserById(int id, String value) {
		List<User> users = userRepository.getUsers();
		User uniqueUsers = users.stream().filter(user -> user.getId()== id).findAny().orElse(null);
		uniqueUsers.setTitle(value);
		uniqueUsers.setBody(value);
		return uniqueUsers;
	}
	
}
