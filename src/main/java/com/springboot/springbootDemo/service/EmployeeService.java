package com.springboot.springbootDemo.service;

import java.util.ArrayList;

import com.springboot.springbootDemo.model.Employee;

public interface EmployeeService {
	public abstract void addEmployee(Employee employee);
	public abstract void updateEmployee(Integer id, Integer newId);
	public abstract void deleteEmployee(Integer id);
	public abstract Employee getEmployee(Integer Id);
	public abstract ArrayList<Employee> getAllEmployees();
	public abstract Integer getEmployeeIndex(Employee employee);
}
