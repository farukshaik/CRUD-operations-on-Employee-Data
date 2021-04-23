package com.exmaple.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.EmployeeDependantsEntity;

public interface EmployeeDependantsRepository extends JpaRepository<EmployeeDependantsEntity, Integer> {
	
	public EmployeeDependantsEntity findById(int id);
	
	public List<EmployeeDependantsEntity> findAllById(int id);

}
