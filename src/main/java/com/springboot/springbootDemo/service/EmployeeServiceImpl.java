package com.springboot.springbootDemo.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.springboot.springbootDemo.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	private static ArrayList<Employee> employeeList = new ArrayList<>();
	
	static {
		employeeList.add(new Employee(1, "Jake", "Reisinger", "jpreisinger@protonmail.com"));
		employeeList.add(new Employee(2, "Cake", "Reisinger", "feaatherrs@yahoo.com"));
	}
	
	@Override
	public void addEmployee(Employee employee) {
		employeeList.add(employee);
	}
	
	@Override
	public void updateEmployee(Integer id, Integer newId) {
		Employee employeeToUpdate = new Employee();
		employeeToUpdate = getEmployee(id);
		
		int index = getEmployeeIndex(employeeToUpdate);
		
		employeeList.get(index).setId(newId);
	}
	
	@Override
	public Integer getEmployeeIndex(Employee employee) {
		if (employeeList.contains(employee)) {
			return employeeList.indexOf(employee);	
		}
		return -1;
	}
	
	@Override
	public Employee getEmployee(Integer id) {
		Employee employeeToFetch = new Employee();
		for (Employee e : employeeList) {
			if (e.getId() == id) {
				employeeToFetch = e;
			}
		}
		
		return employeeToFetch;
	}
	
	@Override
	public void deleteEmployee(Integer id) {
		Employee employeeToDelete = new Employee();
		employeeToDelete = getEmployee(id);
		
		int index = getEmployeeIndex(employeeToDelete);
		
		employeeList.remove(index);
	}
	
	@Override
	public ArrayList<Employee> getAllEmployees() {
		return employeeList;
	}
}
