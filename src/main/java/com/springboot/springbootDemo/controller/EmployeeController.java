package com.springboot.springbootDemo.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.springbootDemo.model.Employee;
import com.springboot.springbootDemo.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	

	@GetMapping("/employees")
	public ResponseEntity<Object> getEmployees() {
		return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
	}
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<Object> getEmployee(@PathVariable("id") Integer id) {
		return new ResponseEntity<>(employeeService.getEmployee(id), HttpStatus.OK);
	}
	
	@RequestMapping("/addEmployee")
	public ResponseEntity<Object> addNewEmployee(@RequestBody Employee employee) throws IOException {
		employeeService.addEmployee(employee);
		return new ResponseEntity<>("Employee added successfully", HttpStatus.CREATED);
	}
	
	@PutMapping("/employee/{id}/{newId}")
	public ResponseEntity<Object> updateEmployee(
			@PathVariable("id") Integer id, 
			@PathVariable("newId") Integer newId) {
		employeeService.updateEmployee(id, newId);
		return new ResponseEntity<>("Employee updated successfully", HttpStatus.OK);
	}
	
	@DeleteMapping("/employee/{id}")
	public ResponseEntity<Object> deleteEmployee(@PathVariable("id") Integer id) {
		employeeService.deleteEmployee(id);
		return new ResponseEntity<>("Employee deleted successfully", HttpStatus.OK);
	}
}
