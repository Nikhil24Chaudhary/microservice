package com.career.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.career.entity.CareerEntity;
import com.career.service.CareerService;

import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/career")
@ApiOperation("Career Api")
public class CareerController {

	@Autowired
	private CareerService careerService;

	@PostMapping("/create")
	public ResponseEntity<CareerEntity> createUser(@RequestBody CareerEntity CareerEntity) {
		System.out.println("createUser");
		CareerEntity entity = careerService.createCareer(CareerEntity);
		return ResponseEntity.status(HttpStatus.OK).body(entity);
	}

	// fetch all user
	@GetMapping
	public ResponseEntity<List<CareerEntity>> getAllCareer() {
		System.out.println("getAllCareer");
		List<CareerEntity> careers = careerService.getAllCareer();
		return ResponseEntity.status(HttpStatus.OK).body(careers);
	}

	// fetch user by id
	@GetMapping("/{id}")
	public CareerEntity findCareerById(@PathVariable int id) {
		System.out.println("findCareerById : " + id);
		return careerService.findCareerById(id);
	}
	
	// fetch user by id
		@GetMapping("/assignments/{userId}")
		public  ResponseEntity<CareerEntity> getallAssignmentsByCompanyId(@PathVariable int userId) {
			System.out.println("findCareerById : " + userId);
			CareerEntity career = careerService.getallAssignmentsOfUser(userId);
			return ResponseEntity.status(HttpStatus.OK).body(career);
		}

}
