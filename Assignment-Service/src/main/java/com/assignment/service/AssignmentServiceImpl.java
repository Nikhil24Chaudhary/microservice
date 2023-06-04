package com.assignment.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.entity.AssignmentEntity;
import com.assignment.repository.AssignmentRepository;

@Service
public class AssignmentServiceImpl implements AssignmentService {
	@Autowired
	private AssignmentRepository assignmentRepository;

	@Override
	public AssignmentEntity createAssignment(AssignmentEntity AssignmentEntity) {
		AssignmentEntity entity = assignmentRepository.save(AssignmentEntity);
		return entity;
	}

	@Override
	public List<AssignmentEntity> getAllAssignments() {
		List<AssignmentEntity> entityList = assignmentRepository.findAll();
		return entityList;
	}

	@Override
	public List<AssignmentEntity> findAssignmentByUserId(int Userid) {
		List<AssignmentEntity> assignmentList = assignmentRepository.findAll();
		List<AssignmentEntity> assignments = assignmentList.stream().filter(a -> a.getUserId() == Userid)
				.collect(Collectors.toList());
		return assignments;
	}

}
