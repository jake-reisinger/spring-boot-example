package com.springboot.springbootDemo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.springbootDemo.model.Pirate;

@RestController
public class PirateController {

	@RequestMapping("/pirate")
	public List<Pirate> getPirates() {
		List<Pirate> pirateList = new ArrayList<Pirate>();
		
		pirateList.add(new Pirate("Blackbeard", "Queen Anne's Revenge"));
		pirateList.add(new Pirate("Charles Vane", "The Ranger"));
		
		return pirateList;
	}
}
