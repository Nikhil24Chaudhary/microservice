package com.career.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.career.entity.CareerEntity;

@Repository
public interface CareerRepository extends  MongoRepository<CareerEntity, String> {

}
