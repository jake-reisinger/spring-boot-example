package com.springboot.springbootDemo.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

import com.springboot.springbootDemo.model.Employee;

public class ConnectToMySql {
	
	private String database;
	private String url;
	private String user;
	private String password;
	private ArrayList<Employee> employeeList = new ArrayList<>();
	
	public ConnectToMySql(String database, String user, String password) {
		this.database = database;
		this.user = user;
		this.password = password;
		this.url = "jdbc:mysql://localhost:3306/" + database + "?allowPublicKeyRetrieval=true&useSSL=false";
	}
	
	public ArrayList<Employee> getEmployees() throws ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		
		try (Connection conn = DriverManager.getConnection(url, user, password)) {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM EMPLOYEES");
			
			while (rs.next()) {
				Employee employee = new Employee();
				
				employee.setId(rs.getInt("id"));
				employee.setFirstName(rs.getString("firstName"));
				employee.setLastName(rs.getString("lastName"));
				employee.setEmail(rs.getString("email"));
				
				employeeList.add(employee);
			}
			
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
		employeeList = removeDuplicates(employeeList);
		
		return employeeList;
	}
	
	public void deleteEmployee(Integer id) throws SQLException {
		try (Connection conn = DriverManager.getConnection(url, user, password)) {
			Statement st = conn.createStatement();
			st.executeUpdate("DELETE FROM employees WHERE id = " + id);
		}
	}
	
	public void updateEmployee(Integer id, String email) throws SQLException {
		try(Connection conn = DriverManager.getConnection(url, user, password)) {
			Statement st = conn.createStatement();
			st.executeUpdate("UPDATE employees SET email = '" + email + "' WHERE id = " + id);
		}
	}
	
	public void addEmployee(String firstName, String lastName, String email) throws SQLException {
		String insertStatement = "INSERT INTO employees (firstName, lastName, email)"
				+ "VALUES ('" 
					+ firstName + "', '"
					+ lastName + "', '"
					+ email + "')";
		
		try(Connection conn = DriverManager.getConnection(url, user, password)) {
			Statement st = conn.createStatement();
			st.executeUpdate(insertStatement);
		}
	}
	
	public static <T> ArrayList<T> removeDuplicates(ArrayList<T> list) {
		Set<T> set = new LinkedHashSet<>();
		
		set.addAll(list);
		list.clear();
		list.addAll(set);
		return list;
	}
}
