package com.springboot.springbootDemo.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.springboot.springbootDemo.model.Employee;
import com.springboot.springbootDemo.model.Pirate;

@Service
public class PirateServiceImpl implements PirateService {
	private static ArrayList<Pirate> pirateList = new ArrayList<>();
	
	static {
		pirateList.add(new Pirate("Jack Sparrow", "Black Pearl"));
		pirateList.add(new Pirate("Blackbeard", "Queen Anne's Revenge"));
	}
	
	@Override
	public ArrayList<Pirate> getAllPirates() {
		return pirateList;
	}
	
	@Override
	public Pirate getPirate(String name) {
		Pirate pirateToFetch = new Pirate();
		for (Pirate p : pirateList) {
			if (p.getName().equals(name)) {
				pirateToFetch = p;
			}
		}
		
		return pirateToFetch;
	}
	
	@Override
	public void updatePirateShip(String name, String shipName) {
		Pirate pirateToUpdate = getPirate(name);
		
		int index = getPirateIndex(pirateToUpdate);
		
		pirateList.get(index).setShipName(shipName);
	}
	
	@Override
	public void deletePirate(String name) {
		Pirate pirateToDelete = getPirate(name);
		
		int index = getPirateIndex(pirateToDelete);
		
		pirateList.remove(index);
	}
	
	@Override
	public void addPirate(Pirate pirate) {
		pirateList.add(pirate);
	}
	
	public Integer getPirateIndex(Pirate pirate) {
		if (pirateList.contains(pirate)) {
			return pirateList.indexOf(pirate);	
		}
		return -1;
	}
}
