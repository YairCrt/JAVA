package com.practicando.practicaCuatro.domain;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "skill")
public class Skill {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idskill")
	private int idSkill;
	private String name;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "assignedSkills")
	private Set<Mercenario> skillSet = new HashSet<>();
	
	public int getIdSkill() {
		return idSkill;
	}
	public void setIdSkill(int idSkill) {
		this.idSkill = idSkill;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Set<Mercenario> getSkillSet() {
		return skillSet;
	}
	public void setSkillSet(Set<Mercenario> skillSet) {
		this.skillSet = skillSet;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(idSkill);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Skill other = (Skill) obj;
		return idSkill == other.idSkill;
	}
	
}
