package com.career.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.career.config.CareerConfig;
import com.career.entity.Assignment;
import com.career.entity.CareerEntity;
import com.career.repository.CareerRepository;

@Service
public class CareerServiceImpl implements CareerService {
	@Autowired
	private CareerRepository careerRepository;

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public CareerEntity createCareer(CareerEntity CareerEntity) {
		CareerEntity entity = careerRepository.save(CareerEntity);
		return entity;
	}

	@Override
	public List<CareerEntity> getAllCareer() {
		List<CareerEntity> entityList = careerRepository.findAll();
		return entityList;
	}

	@Override
	public CareerEntity findCareerById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CareerEntity findCareerByUserId(int userId) {
		List<CareerEntity> entityList = careerRepository.findAll();
		Optional<CareerEntity> entity = entityList.stream().filter(e -> e.getUserId() == userId).findFirst();
		return entity.isPresent() ? entity.get() : null;
	}

	@Override
	public CareerEntity getallAssignmentsOfUser(int userId) {
		CareerEntity entity = findCareerByUserId(userId);
		List<Assignment> assignmentList = callRestService(userId);
		entity.setAssignmentList(assignmentList);
		return entity;
	}

	private List<Assignment> callRestService(int userId) {
		String restUrl = "http://ASSIGNMENT-SERVICE/assignment/{userId}";
		ArrayList response = restTemplate.getForObject(restUrl, ArrayList.class,userId);
		List<Assignment> assignmentList = response;
		return assignmentList;
	}

}
