package com.career.service;

import java.util.List;

import com.career.entity.CareerEntity;

public interface CareerService {

	// create CareerEntity
		public CareerEntity createCareer(CareerEntity CareerEntity);

		// fetch all CareerEntity
		public  List<CareerEntity> getAllCareer();

		// fetch CareerEntity by id
		public CareerEntity findCareerById(int id);
		
		// fetch CareerEntity by id
		public CareerEntity findCareerByUserId(int id);
		
		// fetch all CareerEntity
		public  CareerEntity getallAssignmentsOfUser(int companyId);
}
