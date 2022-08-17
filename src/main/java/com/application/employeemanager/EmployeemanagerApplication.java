package com.application.employeemanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication

/* Component scan scans the packages starting with string 
 * passed and instanciate all the class in the given package so ideally 
 * we should pass groupname.artifactname(com.application.employeemanager) 
 * @ComponentScan(basePackages={"com.application.employeemanager"})
 *	runs bean pre-processor
*/
public class EmployeemanagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeemanagerApplication.class, args);
	}

}
