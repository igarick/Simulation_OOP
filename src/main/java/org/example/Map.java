package org.example;

import org.example.entities.*;

import java.util.*;

public class Map {

    //Карта, содержит в себе коллекцию для хранения
    // существ и их расположения

//    private final Random random = new Random(); // для рандомных координат
//    private final Set<Coordinates> defaultPositions = new HashSet<>(); // для рандомных координат

public void setEntity(Coordinates coordinates, Entity entity) {
    entity.coordinates = coordinates;
    entities.put(coordinates, entity);
}

    private final HashMap<Coordinates, Entity> entities = new HashMap<>();


    public void setDefaultPositions() {
        setEntity(new Coordinates(1, 1), new Grass(new Coordinates(1, 1)));
        setEntity(new Coordinates(2, 2), new Rock(new Coordinates(2, 2)));
        setEntity(new Coordinates(3, 3), new Tree(new Coordinates(3, 3)));
        setEntity(new Coordinates(4, 4), new Herbivore(new Coordinates(4, 4), 2, 100));
        setEntity(new Coordinates(0, 0), new Predator(new Coordinates(0, 0), 1, 100));

    }

    public Entity getEntity(Coordinates coordinates) {
        return entities.get(coordinates);
    }

    public boolean isEmpty(Coordinates coordinates) {
        return !entities.containsKey(coordinates);
    }


//------------------ random coordinates----------------------- // для рандомных координат
//    public void setDefaultPositions() {
//        Coordinates gCoor = getRandomCoor();
//        setEnt(new Grass(gCoor));
//
//        Coordinates rCoor = getRandomCoor();
//        setEnt(new Rock(rCoor));
//
//        Coordinates pCoor = getRandomCoor();
//        setEnt(new Predator(pCoor, 10, 10));
//    }
//
//    public void setEntity(Entity entity) {
//        Coordinates coordinates = entity.coordinates;
//        entities.put(coordinates, entity);
//
//    }
//
//    public Coordinates getRandomCoordinates() {
//        Coordinates coordinates;
//
//        do {
//            coordinates = new Coordinates(random.nextInt(10), random.nextInt(4));
//        } while (!defaultPositions.add(coordinates));
//
//        return coordinates;
//    }
    //------------------ random coordinates-----------------------

}
