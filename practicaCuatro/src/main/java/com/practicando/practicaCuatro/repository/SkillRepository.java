package com.practicando.practicaCuatro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practicando.practicaCuatro.domain.Skill;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Integer> {
	
	public List<Skill> findAllByIdSkill(Integer idSkill);
}
