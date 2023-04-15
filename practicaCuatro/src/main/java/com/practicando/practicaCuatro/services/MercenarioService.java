package com.practicando.practicaCuatro.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practicando.practicaCuatro.domain.Equipment;
import com.practicando.practicaCuatro.domain.Mercenario;
import com.practicando.practicaCuatro.domain.Skill;
import com.practicando.practicaCuatro.repository.EquipmentRepository;
import com.practicando.practicaCuatro.repository.MercenarioRepository;
import com.practicando.practicaCuatro.repository.SkillRepository;

@Service
public class MercenarioService {
	
	@Autowired
	private MercenarioRepository mercRepository;
	
	@Autowired
	private SkillRepository skillRepository;
	
	@Autowired
	private EquipmentRepository equipRepository;
	
	public List<Mercenario> getMercenarioDetails(Integer idMercenario){
		if(idMercenario != null) {
			return mercRepository.findAllByIdMercenario(idMercenario);
		}else {
			return mercRepository.findAll();
		}
	}
	
	public void saveMercenario(Mercenario mercenario) {
		mercRepository.save(mercenario);
	}
	
	public void deleteMercenario(int idMercenario) {
		mercRepository.deleteById(idMercenario);
	}
	
	public Mercenario updateMercenario(Mercenario mercenario, int idMercenario) {
		Mercenario mercenarioUpdate = mercRepository.findById(idMercenario).get();
		mercenarioUpdate.setName(mercenario.getName());
		mercenarioUpdate.setIdParent(mercenario.getIdParent());
		return mercenarioUpdate;
	}
	
	public Mercenario assignEquipmentToMercenario(int idMercenario, int idEquipment) {
		Set<Equipment> equipmentSet = null;
		Mercenario mercenario = mercRepository.findById(idMercenario).get();
		Equipment equipment = equipRepository.findById(idEquipment).get();
		equipmentSet = mercenario.getAssignedEquipment();
		equipmentSet.add(equipment);
		mercenario.setAssignedEquipment(equipmentSet);
		return mercRepository.save(mercenario);
	}
	
	public Mercenario assignSkillToMercenario(int idMercenario, int idSkill) {
		Set<Skill> skillSet = null;
		Mercenario mercenario = mercRepository.findById(idMercenario).get();
		Skill skill = skillRepository.findById(idSkill).get();
		skillSet = mercenario.getAssignedSkills();
		skillSet.add(skill);
		mercenario.setAssignedSkills(skillSet);
		return mercRepository.save(mercenario);
	}
}
