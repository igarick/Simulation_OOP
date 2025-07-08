package org.example.actions;

import org.example.Coordinates;
import org.example.SimulationMap;
import org.example.entities.*;

import java.util.Random;
import java.util.function.Function;

public class EntitySpawnerActionEx implements Actions{

    private final Random random = new Random();

//    public void spawnEntities(SimulationMap simulationMap) {
//        simulationMap.setEntity(new Coordinates(0,0), new Grass(new Coordinates(0,0)));
//        placeEntitiesRandomly(simulationMap, 3, Grass::new);
//        placeEntitiesRandomly(simulationMap, 2, Rock::new);
//        placeEntitiesRandomly(simulationMap, 3, Tree::new);
//        placeEntitiesRandomly(simulationMap,2, c -> new Predator(c, 2, 100));
//        placeEntitiesRandomly(simulationMap,3, c -> new Herbivore(c, 2, 100));
//    }

    public void placeEntitiesRandomly(SimulationMap simulationMap, int count, Function<Coordinates, Entity> factory) {
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
