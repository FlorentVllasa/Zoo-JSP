package de.stl.saar.internetentw1.myzoo.model;

/**
 * Beschreibt ein Tier. 
 * @author christopher
 *
 */
public class Animal {
	/**
	 * Der Name des Tiers. Dabei handelt es sich nur um den Namen der Tierart,
	 * also z.B. Elefant, Giraffe, Tiger.
	 */
	private String animalName;
	/**
	 * Der Name des Bildes. Der Name muss in der JSP aufgeloest werden zu 
	 * images/image.jpg, wobei images der Namen des Verzeichnisses ist, in 
	 * dem die Bilddateien gespeichert sind, und image der Wert dieses Attributs
	 * ist. Die Dateiendung wird nicht in diesem Attribut gespeichert. 
	 */
	private String image;
	/**
	 * True, wenn das Tier sich versteckt hat, sonst false.
	 */
	private boolean hidden;
	/**
	 * Ein Wert zwischen 0 und 10, der den Hunger des Tiers bezeichnet. Ein Tier
	 * mit dem Hunger 0 ist satt.
	 */
	private int hunger;
	
	/**
	 * Erzeugt ein neues Tier.
	 * @param animalName Der Name des Tiers.
	 * @param image Der Name der Bilddatei ohne Dateiendung. Alle Bilder sollen als
	 * jpg-Datei angenommen werden.
	 * @param hunger Der Hunger des Tiers.
	 */
	public Animal(String animalName, String image, int hunger) {
		super();
		this.animalName = animalName;
		this.image = image;
		this.hunger = hunger;
	}
	
	/**
	 * Das Tier wird gefuettert und der Hunger sinkt um eins.
	 */
	public void feed() {
		hunger--;
	}

	public String getAnimalName() {
		return animalName;
	}
	
	public void setAnimalName(String animalName) {
		this.animalName = animalName;
	}
	
	public String getImage() {
		return image;
	}
	
	public void setImage(String image) {
		this.image = image;
	}
	
	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}
	
	public boolean isHidden() {
		return hidden;
	}
	
	public void setHunger(int hunger) {
		this.hunger = hunger;
	}
	
	public int getHunger() {
		return hunger;
	}
}
