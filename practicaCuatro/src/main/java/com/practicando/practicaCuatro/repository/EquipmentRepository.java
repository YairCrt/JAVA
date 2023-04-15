package com.practicando.practicaCuatro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practicando.practicaCuatro.domain.Equipment;

@Repository
public interface EquipmentRepository extends JpaRepository<Equipment, Integer> {

	List<Equipment> findAllByIdEquipment(Integer idEquipment);
}
