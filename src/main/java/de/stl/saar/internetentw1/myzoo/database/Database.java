package de.stl.saar.internetentw1.myzoo.database;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import de.stl.saar.internetentw1.myzoo.model.Animal;
import de.stl.saar.internetentw1.myzoo.model.Compound;

/**
 * Diese Klasse simuliert eine kleine Datenbank mit Hilfe einer statischen Liste
 * und statischen Zugriffsmethoden.
 * @author christopher
 *
 */
public class Database {
	/**
	 * Eine Liste mit allen Gehegen in der Datenbank.
	 */
	private static List<Compound> allCompounds;
	
	/**
	 * Die Gehege werden in die Datenbank geschrieben.
	 */
	static {
		allCompounds = initializeCompounds();
	}
	
	/**
	 * Sucht alle Gehege aus der Datenbank. Diese enthalten dann bereits
	 * die Tiere.
	 * @return Alle in der Datenbank gefundenen Gehege.
	 */
	public static List<Compound> findAllCompounds() {
		return allCompounds;
	}
	
	/**
	 * Sucht ein Gehege anhand des Namens aus der Datenbank. Dabei wird davon
	 * ausgegangen, dass der Name eindeutig ist. Ausserdem berechnet die 
	 * Methode neu, welche Tiere sich im Gehege verstecken.
	 * @param compoundName Der Name des Geheges, das gesucht werden soll.
	 * @return Das gefundene Gehege.
	 */
	public static Compound findCompoundByName(String compoundName) {
		if (allCompounds == null) {
			allCompounds = initializeCompounds();
		}
		Compound selectedCompound = null;
		
		for (Compound compound: allCompounds) {
			if (compound.getCompoundName().equals(compoundName)) {
				selectedCompound = compound;
			}
		}
		
		hideOrUnhideAnimalsInCompound(selectedCompound);
		return selectedCompound;
	}
	
	/**
	 * Berechnet, welche Tiere sich in einem Gehege verstecken und welche
	 * sichtbar sind.
	 * @param compound Das Gehege, dessen Tiere sich verstecken oder sich
	 * zeigen sollen.
	 */
	private static void hideOrUnhideAnimalsInCompound(Compound compound) {
		Random random = new Random();
		for (Animal animal: compound.getAnimals()) {
			animal.setHidden(random.nextBoolean());
		}
	}
	
	/**
	 * Sucht ein Tier anhand des Namens aus der Datenbank. Dabei kann davon 
	 * ausgegangen werden, dass jeder Name eindeutig ist. 
	 * @param animalName Der Name des zu suchenden Tiers.
	 * @return Das gefundene Tier.
	 */
	public static Animal findAnimalByName(String animalName) {
		for (Compound compound: allCompounds) {
			for (Animal animal: compound.getAnimals()) {
				String thisAnimalsName = animal.getAnimalName();
				if (thisAnimalsName.equals(animalName)) {
					return animal;
				}
			}
		}
		return null;
	}
	
	/**
	 * Erzeugt die Testdaten in der simulierten Datenbank. Dabei werden
	 * einige Gehege erzeugt, in welchen sich Tiere befinden. Der Hunger
	 * der Tiere wird ebenfalls initialisiert.
	 * @return Eine Liste mit den erzeugten Gehegen.
	 */
	private static List<Compound> initializeCompounds() {
		Random random = new Random();
		
		List<Compound> allCompounds = new ArrayList<Compound>();
		Compound africaCompound = new Compound("Afrika");
		Animal lion = new Animal("Löwe", "lion", random.nextInt(10));
		africaCompound.addAnimal(lion);
		Animal giraffe = new Animal("Giraffe", "giraffe", random.nextInt(10));
		africaCompound.addAnimal(giraffe);
		Animal zebra = new Animal("Zebra", "zebra", random.nextInt(10));
		africaCompound.addAnimal(zebra);
		Animal tiger = new Animal("Tiger", "tiger", random.nextInt(10));
		africaCompound.addAnimal(tiger);
		Animal elephant = new Animal("Elefant", "elephant", random.nextInt(10));
		africaCompound.addAnimal(elephant);
		
		Compound birdsCompound = new Compound("Vögel");
		Animal eagle = new Animal("Adler", "eagle", random.nextInt(10));
		birdsCompound.addAnimal(eagle);
		Animal condor = new Animal("Kondor", "condor", random.nextInt(10));
		birdsCompound.addAnimal(condor);
		Animal parrot = new Animal("Papagei", "parrot", random.nextInt(10));
		birdsCompound.addAnimal(parrot);
		Animal ostrich = new Animal("Strauß", "ostrich", random.nextInt(10));
		birdsCompound.addAnimal(ostrich);
		
		Compound penguinCompond = new Compound("Pinguine");
		Animal kingPenguin = new Animal("Königspinguin", "kingPenguin", random.nextInt(10));
		penguinCompond.addAnimal(kingPenguin);
		Animal galapagosPenguin = new Animal("Galapagos Pinguin", "galapagosPenguin", random.nextInt(10));
		penguinCompond.addAnimal(galapagosPenguin);
		Animal humboldtPenguin = new Animal("Humboldt Pinguin", "humboldtPenguin", random.nextInt(10));
		penguinCompond.addAnimal(humboldtPenguin);
		Animal rockhopperPenguin = new Animal("Felsenpinguin", "rockhopperPenguin", random.nextInt(10)); 
		penguinCompond.addAnimal(rockhopperPenguin);
		
		Compound snakeCompond = new Compound("Schlangen");
		Animal cobra = new Animal("Kobra", "cobra", random.nextInt(10));
		snakeCompond.addAnimal(cobra);
		Animal python = new Animal("Python", "python", random.nextInt(10));
		snakeCompond.addAnimal(python);
		Animal mamba = new Animal("Mamba", "mamba", random.nextInt(10));
		snakeCompond.addAnimal(mamba);
		Animal adder = new Animal("Keuzotter", "adder", random.nextInt(10));
		snakeCompond.addAnimal(adder);
		
		allCompounds.add(snakeCompond);
		allCompounds.add(africaCompound);
		allCompounds.add(birdsCompound);
		allCompounds.add(penguinCompond);
		
		return allCompounds;
	}
}
