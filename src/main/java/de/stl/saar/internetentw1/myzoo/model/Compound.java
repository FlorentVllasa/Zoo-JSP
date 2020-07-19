package de.stl.saar.internetentw1.myzoo.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Stellt ein Gehege im Zoo dar. Ein Gehege enthaelt eine Menge an Tieren.
 * @author christopher
 *
 */
public class Compound {
	/**
	 * Der Name des Geheges. Bestimmt also, ob es sich bspw. um das Afrika-Haus,
	 * den Vogelkäfig oder das Schlangenhaus handelt.
	 */
	private String compoundName;
	/**
	 * Die Tiere, die in diesem Gehege leben.
	 */
	private List<Animal> animals;
	
	/**
	 * Erzeugt ein neues Gehege. Dabei wird die Liste mit den Tieren erst einmal leer
	 * erzeugt.
	 * @param compoundName Der Name des Geheges.
	 */
	public Compound(String compoundName) {
		animals = new ArrayList<Animal>();
		this.compoundName = compoundName;
	}
	
	/**
	 * Fuegt ein neues Tier ins Gehege hinzu.
	 * @param animal Das neue Tier.
	 */
	public void addAnimal(Animal animal) {
		animals.add(animal);
	}
	
	public String getCompoundName() {
		return compoundName;
	}
	
	public void setCompoundName(String compoundName) {
		this.compoundName = compoundName;
	}
	
	public List<Animal> getAnimals() {
		return animals;
	}
	
	public void setAnimals(List<Animal> animals) {
		this.animals = animals;
	}
}
