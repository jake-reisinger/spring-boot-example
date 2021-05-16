package com.springboot.springbootDemo.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.springbootDemo.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	

	@GetMapping("/employees")
	public ResponseEntity<Object> getEmployees() throws FileNotFoundException, ClassNotFoundException {
		return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
	}
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<Object> getEmployee(@PathVariable("id") Integer id) {
		return new ResponseEntity<>(employeeService.getEmployee(id), HttpStatus.OK);
	}
	
	@PostMapping("/employee/{firstName}/{lastName}/{email}")
	public ResponseEntity<Object> addNewEmployee(
			@PathVariable("firstName") String firstName,
			@PathVariable("lastName") String lastName,
			@PathVariable("email") String email
			) throws IOException, SQLException {
		employeeService.addEmployee(firstName, lastName, email);
		return new ResponseEntity<>("Employee added successfully", HttpStatus.CREATED);
	}
	
	@PutMapping("/employee/{id}/{newEmail}")
	public ResponseEntity<Object> updateEmployee(
			@PathVariable("id") Integer id, 
			@PathVariable("newEmail") String newEmail) throws SQLException {
		employeeService.updateEmployee(id, newEmail);
		return new ResponseEntity<>("Employee updated successfully", HttpStatus.OK);
	}
	
	@DeleteMapping("/employee/{id}")
	public ResponseEntity<Object> deleteEmployee(@PathVariable("id") Integer id) throws ClassNotFoundException, SQLException {
		employeeService.deleteEmployee(id);
		return new ResponseEntity<>("Employee deleted successfully", HttpStatus.OK);
	}
}
