package com.springboot.springbootDemo.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import org.springframework.stereotype.Service;

import com.springboot.springbootDemo.model.Employee;
import com.springboot.springbootDemo.sql.ConnectToMySql;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	private static ArrayList<Employee> employeeList = new ArrayList<>();
	private Properties sqlCredentials = getSqlCredentials();
	
	private String dbUser = sqlCredentials.getProperty("my.dbuser");
	private String dbPwd = sqlCredentials.getProperty("my.dbpwd");
	private ConnectToMySql conn = new ConnectToMySql("development", dbUser, dbPwd);
	
	@Override
	public void addEmployee(String firstName, String lastName, String email) throws SQLException {
		conn.addEmployee(firstName, lastName, email);
	}
	
	@Override
	public void updateEmployee(Integer id, String email) throws SQLException {
		Employee employeeToUpdate = new Employee();
		employeeToUpdate = getEmployee(id);
		
		int index = getEmployeeIndex(employeeToUpdate);
		
		conn.updateEmployee(id, email);
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
	public void deleteEmployee(Integer id) throws SQLException {
		Employee employeeToDelete = new Employee();
		employeeToDelete = getEmployee(id);
		
		int index = getEmployeeIndex(employeeToDelete);
		
		conn.deleteEmployee(id);
	}
	
	@Override
	public ArrayList<Employee> getAllEmployees() throws FileNotFoundException, ClassNotFoundException {	
		employeeList = conn.getEmployees();
		
		return employeeList;
	}
	
	public Properties getSqlCredentials() {
		FileInputStream fis;
		Properties prop = new Properties();
		
		try {
			fis = new FileInputStream("myfile.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return prop;
	}
}
