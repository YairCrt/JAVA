package com.practicando.practicaCuatro.domain;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "mercenario")
public class Mercenario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idmercenario") 
	private int idMercenario;
	private String name;
	@Column(nullable = true, name = "idparent")
	private Integer idParent;
	
	@ManyToMany
	@JoinTable(name = "mercenary_equipment",
			joinColumns = @JoinColumn(name = "merc_id"),
			inverseJoinColumns = @JoinColumn(name = "equip_id"))
	private Set<Equipment> assignedEquipment = new HashSet<>();
	
	@ManyToMany
	@JoinTable(name = "mercenary_skill", 
			joinColumns = @JoinColumn(name = "merc_id"),
			inverseJoinColumns = @JoinColumn(name = "skill_id"))
	private Set<Skill> assignedSkills = new HashSet<>();
	
	public Mercenario() {
		// TODO Auto-generated constructor stub
	}
	
	public Mercenario(int idMercenario, String name, int idParent) {
		super();
		this.idMercenario = idMercenario;
		this.name = name;
		this.idParent = idParent;
	}

	public int getIdMercenario() {
		return idMercenario;
	}
	public void setIdMercenario(int idMercenario) {
		this.idMercenario = idMercenario;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Set<Equipment> getAssignedEquipment() {
		return assignedEquipment;
	}

	public void setAssignedEquipment(Set<Equipment> assignedEquipment) {
		this.assignedEquipment = assignedEquipment;
	}

	public Set<Skill> getAssignedSkills() {
		return assignedSkills;
	}

	public void setAssignedSkills(Set<Skill> assignedSkills) {
		this.assignedSkills = assignedSkills;
	}

	public Integer getIdParent() {
		return idParent;
	}

	public void setIdParent(Integer idParent) {
		this.idParent = idParent;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idMercenario);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mercenario other = (Mercenario) obj;
		return idMercenario == other.idMercenario;
	}
}
