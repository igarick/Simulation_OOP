package org.example.actions;

import org.example.Coordinates;
import org.example.SimulationMap;
import org.example.entities.*;

import java.util.Random;
import java.util.function.Function;
import java.util.function.Predicate;

public class InitAction {

    private final Random random = new Random();

    public void createEntity (SimulationMap simulationMap) {
        placeEntities(simulationMap, 3, Grass::new);
        placeEntities(simulationMap, 2, Rock::new);
        placeEntities(simulationMap, 3, Tree::new);
        placeEntities(simulationMap,2, c -> new Predator(c, 2, 100));
        placeEntities(simulationMap,3, c -> new Herbivore(c, 2, 100));

    }

    public void placeEntities(SimulationMap simulationMap, int count, Function<Coordinates, Entity> factory) {

        for (int i = 0; i < count; i++) {
            Coordinates c = generateCoordinates(simulationMap);
            simulationMap.setEntity(c,factory.apply(c));
        }
//
//        for (int i = 0; i < 3; i++) {
//            Coordinates c = generateCoordinates(simulationMap);
//            simulationMap.setEntity((c), new Grass(c));
//        }
//
//        for (int i = 0; i < 3; i++) {
//            Coordinates c = generateCoordinates(simulationMap);
//            simulationMap.setEntity((c), new Rock(c));
//        }
//
//        for (int i = 0; i < 2; i++) {
//            Coordinates c = generateCoordinates(simulationMap);
//            simulationMap.setEntity((c), new Tree(c));
//        }
//
//        for (int i = 0; i < 3; i++) {
//            Coordinates c = generateCoordinates(simulationMap);
//            simulationMap.setEntity((c), new Herbivore((c), 3, 100));
//        }
//
//        for (int i = 0; i < 2; i++) {
//            Coordinates c = generateCoordinates(simulationMap);
//            simulationMap.setEntity((c), new Predator((c), 2, 100));
//        }
    }

    public Coordinates generateCoordinates(SimulationMap simulationMap) {
        Coordinates coordinates;

        do {
            coordinates = new Coordinates(random.nextInt(simulationMap.rowCount()), random.nextInt(simulationMap.columnCount()));
        } while (!simulationMap.isEmpty(coordinates));

        return coordinates;
    }

}
