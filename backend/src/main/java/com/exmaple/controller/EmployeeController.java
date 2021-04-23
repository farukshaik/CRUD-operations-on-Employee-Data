package com.exmaple.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.EmployeeEntity;
import com.exmaple.modelclass.Employee;
import com.exmaple.modelclass.EmployeeDependants;
import com.exmaple.modelclass.EmployeeEducation;
import com.exmaple.modelclass.EmployeeUpdateData;
import com.exmaple.service.EmployeeService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders  = "*")
public class EmployeeController {

	@Autowired
	public EmployeeService addData;

	@PostMapping(value = "/addEmployee")
	public @ResponseBody void addEmployee(@RequestBody Employee employeeData) {
		addData.getServiceToAddEmployeeData(employeeData);
	}

	@PostMapping(value = "/addEmployeeDependants")
	public @ResponseBody void addEmployeeDependants(@Valid @RequestBody EmployeeDependants dependantsData) {
		addData.getServiceToAddEmployeeDependantsData(dependantsData);
	}

	@PostMapping(value = "/addEmployeeEduQuals")
	public @ResponseBody void addEmployeeEduQuals(@RequestBody EmployeeEducation eduQualsData) {
		addData.getServiceToAddEmployeeEduQuals(eduQualsData);
	}

	@PostMapping(value = "/deleteEmployee")
	public @ResponseBody void deleteEmployee(@RequestParam(name = "id") int id) {
		addData.getServiceToDeleteEmployee(id);
	}

	@PostMapping(value = "/updateEmployeeData")
	public @ResponseBody void updateEmployeeData(@Valid @RequestBody EmployeeUpdateData updateData) {
		addData.getServiceToUpdateEmployeeDetails(updateData);
	}

	@GetMapping(value = "/fetchByIdForUpdate")
	public @ResponseBody EmployeeEntity fetchByIdForUpdate(@RequestParam(name = "id") int id) {
		return addData.getServiceToFetchByIdForUpdate(id);
	}
	
	
	@GetMapping(value = "/getEmployeeData")
	public @ResponseBody EmployeeEntity getEmployeeData(@RequestParam(name = "employmentId") String employmentId) {
		return addData.getServiceToGetEmployeeData(employmentId);
	}
	
	
	@GetMapping(value = "/getEmployeeDataByLike")
	public @ResponseBody List<EmployeeEntity> getEmployeeDataByLike(@RequestParam(name = "firstName") String firstName) {
		return addData.getServiceToGetEmployeeDataByLike(firstName);
	}
	

}
