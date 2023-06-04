package com.user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.user.entity.Career;
import com.user.entity.User;
import com.user.repository.UserRepository;

@Service
public class UserServiceImpal implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public User createUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		List<User> users = userRepository.findAll();
		return users;
	}

	@Override
	public User getUserById(int userId) {
		List<User> users = userRepository.findAll();
		Optional<User> user = users.stream().filter(u -> u.getId() == userId).findFirst();
		return user.isPresent() ? user.get() : null;
	}

	@Override
	public User findUserProfileById(int userId) {
		User user = getUserById(userId);
		HashMap<String, Object> careerList = callRestService(userId);
		user.setCareers(careerList);
		return user;
	}
	
	private HashMap<String, Object> callRestService(int userId) {
		String serviceAppName = "CAREER-SERVICE";
		String restUrl = "http://CAREER-SERVICE/career/assignments/{userId}";
		String response = restTemplate.getForObject(restUrl, String.class,userId);
		JSONParser parser  = new JSONParser(response);
		HashMap<String, Object> hpHashMap = new HashMap<>();
		try {
			hpHashMap= parser.parseObject();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hpHashMap;
	}
}
