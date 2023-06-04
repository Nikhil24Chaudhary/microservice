package com.assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.assignment.config.AssignmentConfig;
import com.assignment.entity.AssignmentEntity;
import com.assignment.service.AssignmentService;

@Controller
@RequestMapping("/assignment")
public class AssignmentController {

	@Autowired
	private AssignmentService assignmentService;

	@Autowired
	private AssignmentConfig assignmentConfig;
	
	@PostMapping("/create")
	public ResponseEntity<AssignmentEntity> createAssignment(@RequestBody AssignmentEntity AssignmentEntity) {
		System.out.println("createAssignment");
		AssignmentEntity entity = assignmentService.createAssignment(AssignmentEntity);
		return ResponseEntity.status(HttpStatus.OK).body(entity);
	}

	// fetch all user
	@GetMapping("/assignments")
	public ResponseEntity<List<AssignmentEntity>> getAllAssignments() {
		System.out.println("getAllAssignment");
		List<AssignmentEntity> assignments = assignmentService.getAllAssignments();
		return ResponseEntity.status(HttpStatus.OK).body(assignments);
	}

	// fetch user by id
	@GetMapping("/{userId}")
	public ResponseEntity<List<AssignmentEntity>> findAssignmentById(@PathVariable int userId) {
		System.out.println("findAssignmentById : " + userId);
		List<AssignmentEntity> assignment = assignmentService.findAssignmentByUserId(userId);
		return ResponseEntity.status(HttpStatus.OK).body(assignment);
	}

}
