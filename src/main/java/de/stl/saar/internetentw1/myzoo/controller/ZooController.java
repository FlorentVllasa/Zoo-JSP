package de.stl.saar.internetentw1.myzoo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import de.stl.saar.internetentw1.myzoo.database.Database;
import de.stl.saar.internetentw1.myzoo.model.Animal;

/**
 * Der Controller steuert die Navigation innerhalb der Anwendung. Die Methoden
 * geben an, wohin die Navigation beim Aufruf einer bestimmten URL erfolgen soll,
 * nehmen Request-Parameter entgegen, die von Formularen gesendet wurden, und 
 * schreiben neue Parameter in die Requests.
 * @author christopher
 *
 */
@Controller
public class ZooController {

	/**
	 * Endpunkt Zoo-Anfang
	 * @return zoo
	 */
    @RequestMapping("/")
    public String showStart(){
        return "zoo";
    }

    /**
     * Endpunkt Gehege
     * @param model 
     * @param chosenCompound
     * @return zoo, wenn kein Gehege angeklickt worden ist; ansonsten compound mit den Tieren
     */
    @RequestMapping("compound")
    public String showCompound(Map<String, Object> model, String chosenCompound){
        if(chosenCompound == null){
            model.put("noDecision", true);
            return "zoo";	
        }
        
        List<Animal> animals = Database.findCompoundByName(chosenCompound).getAnimals();
        model.put("compoundName", chosenCompound);
        model.put("animals", animals);
        return "compound";
    }
    
    /**
     * Endpunkt Tier
     * @param model
     * @param chosenAnimal
     * @param compoundName
     * @param feed
     * @return compound, wenn kein Tier ausgewählt worden ist; ansonsten animal mit dem angeklickten Tier
     */
    @RequestMapping("animal")
    public String showAnimal(Map<String, Object> model, String chosenAnimal, String compoundName, String feed){
        if(chosenAnimal == null){
            List<Animal> animals = Database.findCompoundByName(compoundName).getAnimals();
            model.put("compoundName", compoundName);
            model.put("animals" , animals);
            model.put("noDecision", true);
            return "compound";
        }
        
        Animal animal = Database.findAnimalByName(chosenAnimal);
        
        // wenn Button 'feed' angeklickt worden ist, dann verringere Hunger um 1
        if(feed != null) {
            animal.feed();
        }
        
        model.put("animal", animal);
        model.put("compoundName", compoundName);
        model.put("chosenCompound", compoundName);
        return "animal";
    } 
}
