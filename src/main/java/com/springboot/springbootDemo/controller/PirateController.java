package com.springboot.springbootDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.springbootDemo.model.Pirate;
import com.springboot.springbootDemo.service.PirateService;

@RestController
public class PirateController {
	
	@Autowired
	PirateService pirateService;

	@GetMapping("/pirate/{name}")
	public ResponseEntity<Object> getPirate(@PathVariable("name") String name) {
		return new ResponseEntity<>(pirateService.getPirate(name), HttpStatus.OK);
	}
	
	@GetMapping("/pirates")
	public ResponseEntity<Object> getAllPirates() {
		return new ResponseEntity<>(pirateService.getAllPirates(), HttpStatus.OK);
	}
	
	@PostMapping("/pirate")
	public ResponseEntity<Object> addPirate(@RequestBody Pirate pirate) {
		pirateService.addPirate(pirate);
		return new ResponseEntity<>("Pirate " + pirate.getName() + " added successfully", HttpStatus.CREATED);
	}
	
	@PutMapping("/pirate/{name}/{shipName}")
	public ResponseEntity<Object> updatePirate(
			@PathVariable("name") String name,
			@PathVariable("shipName") String shipName) {
		pirateService.updatePirateShip(name, shipName);
		return new ResponseEntity<>("Pirate's ship's name updated successfully", HttpStatus.OK);
	}
	
	@DeleteMapping("/pirate/{name}")
	public ResponseEntity<Object> deletePirate(@PathVariable("name") String name) {
		pirateService.deletePirate(name);
		return new ResponseEntity<>("Pirate " + name + " successfully deleted", HttpStatus.OK);
	}
}
