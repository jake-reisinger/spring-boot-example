package com.springboot.springbootDemo.service;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.springboot.springbootDemo.model.Employee;

public interface EmployeeService {
	public abstract void addEmployee(String firstName, String lastName, String email) throws SQLException;
	public abstract void updateEmployee(Integer id, String email) throws SQLException;
	public abstract void deleteEmployee(Integer id) throws SQLException;
	public abstract Employee getEmployee(Integer Id);
	public abstract ArrayList<Employee> getAllEmployees() throws FileNotFoundException, ClassNotFoundException;
	public abstract Integer getEmployeeIndex(Employee employee);
}
