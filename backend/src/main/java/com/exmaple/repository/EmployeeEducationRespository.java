package com.exmaple.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.EmployeeEducationEntity;

public interface EmployeeEducationRespository  extends JpaRepository<EmployeeEducationEntity, Integer>{
	
	
	public EmployeeEducationEntity findById(int id);
	
	
	public List<EmployeeEducationEntity> findAllById(int id);

}
