package com.exmaple.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.entity.EmployeeEntity;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {

	public EmployeeEntity findById(int id);
	
	public EmployeeEntity findByEmploymentId(String employeeId);
	@Query("Select c from EntityClass c where c.firstName like %:firstName% or c.lastName like %:lastName%")
	public List<EmployeeEntity> findByFirstNameLikeOrLastNameLike(String firstName, String lastName);

}
