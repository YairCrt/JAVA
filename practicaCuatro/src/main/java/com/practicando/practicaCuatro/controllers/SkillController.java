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

import com.practicando.practicaCuatro.domain.Skill;
import com.practicando.practicaCuatro.services.SkillService;

@RestController
@RequestMapping("/skills")
public class SkillController {
	
	@Autowired
	private SkillService skillService;
	
	@GetMapping(value = {"/getSkills", "/{idSkill}"})
	public List<Skill> getSkills(@PathVariable(required = false) Integer idSkill){
		return skillService.getSkillDetails(idSkill);
	}
	
	@PostMapping("/save")
	public ResponseEntity<Skill> saveSkill(@RequestBody Skill skill){
		skillService.saveSkill(skill);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete/{idSkill}")
	public ResponseEntity<Void> deleteSkill(@PathVariable int idSkill){
		skillService.deleteSkill(idSkill);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
