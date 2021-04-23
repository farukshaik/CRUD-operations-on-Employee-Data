package com.exmaple.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.EmployeeDependantsEntity;
import com.example.entity.EmployeeEducationEntity;
import com.example.entity.EmployeeEntity;
import com.exmaple.modelclass.Employee;
import com.exmaple.modelclass.EmployeeDependants;
import com.exmaple.modelclass.EmployeeEducation;
import com.exmaple.modelclass.EmployeeUpdateData;
import com.exmaple.repository.EmployeeDependantsRepository;
import com.exmaple.repository.EmployeeEducationRespository;
import com.exmaple.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	public EmployeeRepository repo;

	@Autowired
	public EmployeeDependantsRepository repoDependants;

	@Autowired
	public EmployeeEducationRespository repoEduQuals;

	public void getServiceToAddEmployeeData(Employee employeeData) {
		EmployeeEntity entityObj = new EmployeeEntity();
		entityObj.setFirstName(employeeData.getFirstName());
		entityObj.setLastName(employeeData.getLastName());
		entityObj.setStartDate(employeeData.getStartDate());
		entityObj.setEmploymentId(employeeData.getEmploymentId());
		entityObj.setDesignation(employeeData.getDesignation());
		entityObj.setDepartment(employeeData.getDepartment());
		entityObj.setEndDate(employeeData.getEndDate());
		entityObj.setStatus(employeeData.getStatus());
		entityObj.setDob(employeeData.getDob());
		entityObj.setReportingManager(employeeData.getReportingManager());
		entityObj.setGender(employeeData.getGender());
		entityObj.setBloodGroup(employeeData.getBloodGroup());
		entityObj.setAddress(employeeData.getAddress());
		repo.save(entityObj);

	}

	public void getServiceToAddEmployeeDependantsData(EmployeeDependants dependantsData) {
		EmployeeDependantsEntity dependantsObj = new EmployeeDependantsEntity();

		dependantsObj.setFirstName(dependantsData.getFirstName());
		dependantsObj.setLastName(dependantsData.getLastName());
		dependantsObj.setDob(dependantsData.getDob());
		dependantsObj.setGender(dependantsData.getGender());
		dependantsObj.setRelationship(dependantsData.getRelationship());
		dependantsObj.setId(dependantsData.getId());
		repoDependants.save(dependantsObj);

	}

	public void getServiceToAddEmployeeEduQuals(EmployeeEducation eduQualsData) {

		EmployeeEducationEntity eduQuals = new EmployeeEducationEntity();

		eduQuals.setType(eduQualsData.getType());
		eduQuals.setStartDate(eduQualsData.getStartDate());
		eduQuals.setEndDate(eduQualsData.getEndDate());
		eduQuals.setInstitution(eduQualsData.getInstitution());
		eduQuals.setPercentage(eduQualsData.getPercentage());
		eduQuals.setAddress(eduQualsData.getAddress());
		eduQuals.setId(eduQualsData.getId());
		repoEduQuals.save(eduQuals);
	}

	public void getServiceToDeleteEmployee(int id) {
		EmployeeEntity e1 = repo.findById(id);
		List<EmployeeDependantsEntity> e2 = repoDependants.findAllById(id);
		List<EmployeeEducationEntity> e3 = repoEduQuals.findAllById(id);

		repoEduQuals.deleteAll(e3);
		repoDependants.deleteAll(e2);
		repo.delete(e1);
	}

	public EmployeeEntity getServiceToFetchByIdForUpdate(int id) {
		EmployeeEntity ec = repo.findById(id);

		return ec;
	}

	public void getServiceToUpdateEmployeeDetails(EmployeeUpdateData updateData) {
		EmployeeEntity ec = repo.findByEmploymentId(updateData.getEmploymentId());

		ec.setFirstName(updateData.getFirstName());
		ec.setLastName(updateData.getLastName());
		ec.setEmploymentId(updateData.getEmploymentId());
		ec.setStartDate(updateData.getStartDate());
		ec.setEndDate(updateData.getEndDate());
		ec.setDesignation(updateData.getDesignation());
		ec.setDepartment(updateData.getDepartment());
		ec.setStatus(updateData.getStatus());
		ec.setDob(updateData.getDob());
		ec.setReportingManager(updateData.getReportingManager());
		ec.setGender(updateData.getGender());
		ec.setBloodGroup(updateData.getBloodGroup());
		ec.setAddress(updateData.getAddress());
		repo.save(ec);
	}

	public EmployeeEntity getServiceToGetEmployeeData(String employeeId) {
		EmployeeEntity ec = repo.findByEmploymentId(employeeId);
		return ec;
	}

	public List<EmployeeEntity> getServiceToGetEmployeeDataByLike(String firstName) {
		List<EmployeeEntity> ec = repo.findByFirstNameLikeOrLastNameLike(firstName, firstName);
		return ec;
	}

}
