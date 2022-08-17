package com.application.employeemanager.service;

import java.util.List;

import com.application.employeemanager.model.Employee;

public interface IEmployeeService {
	public Employee addEmployee(Employee employee);
	public List<Employee> findAllEmployee();
	public Employee updateEmployee(Employee employee);
	public void deleteEmployee(Long id);
	public Employee findEmployeeById(Long id);
	//method to pring employeeID with employee name using own db session ?
}
