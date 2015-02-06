
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

import java.util.List;
import java.util.Random;

/**
 * Describes a hunter that hunts all animals.
 * 
 * @author Alistair Madden <phantommelon@gmail.com> 
 * @version 1.0
 */
public class Hunter implements Actor {
    
    //Random number generator to determine when the Hunter becomes inactive.
    private static final Random rand = Randomizer.getRandom();
    
    // Whether the hunter is alive or not.
    private boolean alive;
    
    // The hunter's field.
    private Field field;
    
    // The hunter's position in the field.
    private Location location;
    
    /**
     * Create a new Hunter at location in field.
     * 
     * @param field The field currently occupied.
     * @param location The location within the field.
     */
    public Hunter(Field field, Location location) {
        this.field = field;
        this.location = location;
    }
    
    @Override
    public void act(List<Animal> newAnimal) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
