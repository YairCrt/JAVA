package com.practicando.practicaCuatro.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practicando.practicaCuatro.domain.Mercenario;
import com.practicando.practicaCuatro.services.MercenarioService;

@RestController
@RequestMapping("/mercenarios")
public class MercenarioController {
	
	@Autowired
	private MercenarioService mercService;
	
	@GetMapping(value = {"/getMercenarios", "/{idMercenario}"})
	public List<Mercenario> getMercenarios(@PathVariable(required = false) Integer idMercenario){
		return mercService.getMercenarioDetails(idMercenario);
	}
	
	@PostMapping("/save")
		public ResponseEntity<Mercenario> saveMercenario(@RequestBody Mercenario mercenario){
			mercService.saveMercenario(mercenario);
			return new ResponseEntity<>(HttpStatus.CREATED);
		}
	
	@PutMapping("/update/{idMercenario}")
	public ResponseEntity<Mercenario> updateMercenario(@RequestBody Mercenario mercenario, @PathVariable int idMercenario){
		return new ResponseEntity<Mercenario>(mercService.updateMercenario(mercenario, idMercenario), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{idMercenario}")
	public ResponseEntity<Void> deleteMercenario(@PathVariable int idMercenario){
		mercService.deleteMercenario(idMercenario);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	
	@PutMapping("/{idMercenario}/equipment/{idEquipment}")
	public Mercenario assignEquipmentToMercenario(@PathVariable int idMercenario, @PathVariable int idEquipment) {
		return mercService.assignEquipmentToMercenario(idMercenario, idEquipment);
	}
	
	@PutMapping("{idMercenario}/skill/{idSkill}")
	public Mercenario assignSkillToMercenario(@PathVariable int idMercenario, @PathVariable int idSkill) {
		return mercService.assignSkillToMercenario(idMercenario, idSkill);
	}
}
