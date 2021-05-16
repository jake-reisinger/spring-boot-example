package com.springboot.springbootDemo.service;

import java.util.ArrayList;

import com.springboot.springbootDemo.model.Pirate;

public interface PirateService {
	public abstract Pirate getPirate(String name);
	public abstract ArrayList<Pirate> getAllPirates();
	public abstract void deletePirate(String name);
	public abstract void updatePirateShip(String name, String shipName);
	public abstract void addPirate(Pirate pirate);
}
