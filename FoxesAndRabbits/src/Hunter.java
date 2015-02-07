
/*
 * Copyright 2015 Alistair Madden <phantommelon@gmail.com>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * Describes a hunter that hunts all animals.
 * 
 * @author Alistair Madden <phantommelon@gmail.com> 
 * @version 1.0
 */
public class Hunter extends Actor {

    // A shared random number generator to control activity.
    private static final Random rand = Randomizer.getRandom();
    
    private static final double activeProb = 0.99;
    
    public Hunter(Field field, Location location) {
        super(field, location);
    }

    @Override
    public void act(List<Animal> newAnimals) {
        if(isActive()) {
            Location location = getLocation();
            Location newLocation = findTarget(location);
            if(newLocation == null) { 
                // No target found - try to move to a free location.
                newLocation = getField().freeAdjacentLocation(location);
            }
            // See if it was possible to move.
            if(newLocation != null) {
                setLocation(newLocation);
            }
        }
        
    }
    
    private boolean isActive() {
        
        if(rand.nextDouble() > activeProb) {
            this.setDead();
            return false;
        }
        
        else {
            return true;
        }
    }

    private Location findTarget(Location location) {
        Field field = getField();
        List<Location> adjacent = field.adjacentLocations(getLocation());
        Iterator<Location> it = adjacent.iterator();
        while(it.hasNext()) {
            Location where = it.next();
            Object animal = field.getObjectAt(where);
            if(animal instanceof Rabbit) {
                Rabbit rabbit = (Rabbit) animal;
                if(rabbit.isAlive()) { 
                    rabbit.setDead();
                    // Remove the dead rabbit from the field.
                    return where;
                }
            }
            if(animal instanceof Fox) {
                Fox fox = (Fox) animal;
                if(fox.isAlive()) { 
                    fox.setDead();
                    // Remove the dead fox from the field.
                    return where;
                }
            }
            if(animal instanceof Wolf) {
                Wolf wolf = (Wolf) animal;
                if(wolf.isAlive()) {
                    wolf.setDead();
                    //Remove the dead wolf from the field.
                    return where;
                }
            }
        }
        return null;
    }
}
