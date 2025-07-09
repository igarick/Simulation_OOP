package org.example.actions;

import org.example.Coordinates;
import org.example.SimulationMap;
import org.example.entities.*;

import java.util.Random;
import java.util.function.Function;

public class EntitySpawnerAction implements Actions{

    private final Random random = new Random();

    @Override
    public void execute(SimulationMap simulationMap) {        //spawnEntities
//        simulationMap.setEntity(new Coordinates(0,0), new Grass());
        simulationMap.setEntity(new Coordinates(0,4), new Grass());
        simulationMap.setEntity(new Coordinates(6,6), new Grass());
//        simulationMap.setEntity(new Coordinates(6,6), new Grass());
        simulationMap.setEntity(new Coordinates(1,0), new Tree());
        simulationMap.setEntity(new Coordinates(1,1), new Tree());
        simulationMap.setEntity(new Coordinates(1,2), new Tree());
        simulationMap.setEntity(new Coordinates(1,3), new Tree());
        simulationMap.setEntity(new Coordinates(1,4), new Tree());
//        simulationMap.setEntity(new Coordinates(1,5), new Tree());
//        simulationMap.setEntity(new Coordinates(1,6), new Tree());


        simulationMap.setEntity(new Coordinates(2,6), new Rock());




        simulationMap.setEntity(new Coordinates(0,0), new Predator(new Coordinates(0,0)));
        simulationMap.setEntity(new Coordinates(0,1), new Herbivore(new Coordinates(0,1)));



//        placeEntitiesRandomly(simulationMap, 3, _ -> new Grass());
//        placeEntitiesRandomly(simulationMap, 2, _ -> new Rock());
//        placeEntitiesRandomly(simulationMap, 3, _ -> new Tree());
//        placeEntitiesRandomly(simulationMap,2, c -> new Predator(c,2, 100));
//        placeEntitiesRandomly(simulationMap,3, c -> new Herbivore(c, 2, 100));
    }

    public void placeEntitiesRandomly(SimulationMap simulationMap, int count, Function<Coordinates, Entity> factory) { //Function<Coordinates, Entity> factory
        for (int i = 0; i < count; i++) {
            Coordinates c = generateCoordinates(simulationMap);
            simulationMap.setEntity(c,factory.apply(c));
        }
    }

    private Coordinates generateCoordinates(SimulationMap simulationMap) {
        Coordinates coordinates;

        do {
            coordinates = new Coordinates(random.nextInt(simulationMap.height()), random.nextInt(simulationMap.width()));
        } while (!simulationMap.isEmpty(coordinates));

        return coordinates;
    }

}
