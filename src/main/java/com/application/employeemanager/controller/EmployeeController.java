package com.application.employeemanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.employeemanager.model.Employee;
import com.application.employeemanager.service.IEmployeeService;

//Making the class a Rest Service
@RestController
@RequestMapping("/employee") 	//default url mapping
public class EmployeeController {
	@Autowired
	private IEmployeeService employeeService;
	
	@GetMapping("/")
	public String greet(){
		return "Hello!!!!";
	}
	//findAllEmployee
	@GetMapping("/all")
	public ResponseEntity<List<Employee>> getAllEmployee(){
		//whenever we call employeeService.anyMethod() based on spring autowired spring will instanciate the bean for us when its called
		List<Employee> employees=employeeService.findAllEmployee();
		return new ResponseEntity<>(employees, HttpStatus.OK);
	}
	//find employee by id
	@GetMapping("/find/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id){
		Employee employee=null;
		try{
			employee=employeeService.findEmployeeById(id);
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}
	//Add employee
	@PostMapping("/add")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
		return new ResponseEntity<>(employeeService.addEmployee(employee),HttpStatus.CREATED);
	}
	//Update employee
	@PutMapping("/update")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
		return new ResponseEntity<>(employeeService.updateEmployee(employee),HttpStatus.OK);
	}
	//Delete employee
	@PutMapping("/delete/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable("id")Long id){
		employeeService.deleteEmployee(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
