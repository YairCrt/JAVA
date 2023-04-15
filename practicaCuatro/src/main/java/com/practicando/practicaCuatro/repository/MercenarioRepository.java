package com.practicando.practicaCuatro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practicando.practicaCuatro.domain.Mercenario;

@Repository
public interface MercenarioRepository extends JpaRepository<Mercenario, Integer> {

	public List<Mercenario> findAllByIdMercenario(Integer idMercenario);
	
}
