package com.practicando.practicaCuatro.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practicando.practicaCuatro.domain.Equipment;
import com.practicando.practicaCuatro.repository.EquipmentRepository;

@Service
public class EquipmentService {
	
	@Autowired
	private EquipmentRepository equipRepository;
	
//	public List<Equipment> getEquipments(){
//		return equipRepository.findAll();
//	}
	public List<Equipment> getEquipmentDetails(Integer idEquipment){
		if(null != idEquipment) {
			return equipRepository.findAllByIdEquipment(idEquipment);
		}else {
			return equipRepository.findAll();
		}
	}
	
	public void saveEquipment(Equipment equipment) {
		equipRepository.save(equipment);
	}
	
	public void deleteEquipment(int idEquipment) {
		equipRepository.deleteById(idEquipment);
	}
}
