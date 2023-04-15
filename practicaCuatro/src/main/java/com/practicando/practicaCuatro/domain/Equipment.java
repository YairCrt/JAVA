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
@Table(name = "equipment")
public class Equipment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idequipment")
	private int idEquipment;
	private String name;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "assignedEquipment")
	private Set<Mercenario> equipmentSet = new HashSet<>();

	public int getIdEquipment() {
		return idEquipment;
	}

	public void setIdEquipment(int idEquipment) {
		this.idEquipment = idEquipment;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Mercenario> getEquipmentSet() {
		return equipmentSet;
	}

	public void setEquipmentSet(Set<Mercenario> equipmentSet) {
		this.equipmentSet = equipmentSet;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idEquipment);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Equipment other = (Equipment) obj;
		return idEquipment == other.idEquipment;
	}
	
}
