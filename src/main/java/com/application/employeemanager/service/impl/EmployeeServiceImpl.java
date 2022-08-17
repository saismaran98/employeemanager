package com.application.employeemanager.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.application.employeemanager.exception.UserNotFoundException;
import com.application.employeemanager.model.Employee;
import com.application.employeemanager.repo.EmployeeRepo;
import com.application.employeemanager.service.IEmployeeService;
/*
 * Service Layer talks to application controller which is exposed to user, and service layer
 * interacts with database. 
 */
@Service
public class EmployeeServiceImpl implements IEmployeeService{
	private final EmployeeRepo employeeRepo;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepo employeeRepo){
		this.employeeRepo=employeeRepo;
	}
	//CURD: Create
	public Employee addEmployee(Employee employee){
		/*
		 * we receive employee object with all fields except 
		 * id: primary-key which is auto generated
		 * and employee code which we generate a random value and then save in database. 
		 */
		
		employee.setEmployeeCode(UUID.randomUUID().toString());
		return employeeRepo.save(employee);
	}
	//CURD:Retrieve 
	public List<Employee> findAllEmployee(){
		//employeeRepo inteface extends JPARepository which handles findAll implementation, employeeRepo can also be called as employeeDAO
		return employeeRepo.findAll();
	}
	//CURD: Update
	public Employee updateEmployee(Employee employee){
		return employeeRepo.save(employee);
	}
	//CURD: Delete
	public void deleteEmployee(Long id){
		employeeRepo.deleteEmployeeById(id);
	}
	//Exception handling and use of Optional for find funciton. 
	public Employee findEmployeeById(Long id){
		return employeeRepo.findEmployeeById(id)
				.orElseThrow(()-> new UserNotFoundException("User with id "+id+" not found in DB"));
	}
	
	
}
