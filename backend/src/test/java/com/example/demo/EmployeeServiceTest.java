package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.example.entity.EmployeeEntity;
import com.exmaple.service.EmployeeService;

class EmployeeServiceTest {

	@Test
	public void getServiceToGetEmployeeData_employeeFirstName() {
		EmployeeService ec = new EmployeeService();
		EmployeeEntity data = ec.getServiceToGetEmployeeData("19mcmt42");

		assertEquals("faruk", data.getFirstName());

	}
	
	@Test
	public void getServiceToGetEmployeeData_employeeLastName() {
		EmployeeService ec = new EmployeeService();
		EmployeeEntity data = ec.getServiceToGetEmployeeData("19mcmt42");

		assertEquals("shaik", data.getLastName());

	}
}
