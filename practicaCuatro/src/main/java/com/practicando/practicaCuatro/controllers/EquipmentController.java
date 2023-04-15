package com.practicando.practicaCuatro.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practicando.practicaCuatro.domain.Equipment;
import com.practicando.practicaCuatro.services.EquipmentService;

@RestController
@RequestMapping("/equipamientos")
public class EquipmentController {
	
	@Autowired
	private EquipmentService equipService;
	
//	@GetMapping
//	public ResponseEntity<List<Equipment>> getEquipments(){
//		return new ResponseEntity<List<Equipment>>(equipService.getEquipments(), HttpStatus.OK);
//	}
	@GetMapping(value = {"/getEquipments", "/{idEquipment}"})
	public List<Equipment> getEquipments(@PathVariable(required = false) Integer idEquipment){
		return equipService.getEquipmentDetails(idEquipment);
	}
	
	@PostMapping("/save")
	public ResponseEntity<Equipment> saveEquipment(@RequestBody Equipment equipment){
		equipService.saveEquipment(equipment);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete/{idEquipment}")
	public ResponseEntity<Void> deleteEquipment(@PathVariable int idEquipment){
		equipService.deleteEquipment(idEquipment);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
