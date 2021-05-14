package com.springboot.springbootDemo.model;

public class Pirate {
	
	public Pirate() {
		
	}
	
	public Pirate(String name, String shipName) {
		super();
		this.name = name;
		this.shipName = shipName;
	}
	
	private String name;
	private String shipName;
	
	public String getName() {
		return name;
	}
	
	public String getShipName() {
		return shipName;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setShipName(String shipName) {
		this.shipName = shipName;
	}
	
	@Override
	public String toString() {
		return "Pirate [name=" + name + ", shipName=" + shipName;
	}
}
