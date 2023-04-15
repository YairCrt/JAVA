package com.practicando.practicaCuatro.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practicando.practicaCuatro.domain.Skill;
import com.practicando.practicaCuatro.repository.SkillRepository;

@Service
public class SkillService {
	
	@Autowired
	private SkillRepository skillRepository;
	
	public List<Skill> getSkillDetails(Integer idSkill){
		if(null != idSkill) {
			return skillRepository.findAllByIdSkill(idSkill);
		}else {
			return skillRepository.findAll();
		}
	}
	
	public void saveSkill(Skill skill) {
		skillRepository.save(skill);
	}
	
	public void deleteSkill(int idSkill) {
		skillRepository.deleteById(idSkill);
	}
	
}
