package org.example.actions;

import org.example.Coordinates;
import org.example.SimulationMap;
import org.example.entities.*;

import java.util.Random;

public class InitAction {

    private final Random random = new Random();

    public void placeEntities(SimulationMap simulationMap) {

        for (int i = 0; i < 3; i++) {
            Coordinates c = generateCoordinates(simulationMap);
            simulationMap.setEntity((c), new Grass(c));
        }

        for (int i = 0; i < 3; i++) {
            Coordinates c = generateCoordinates(simulationMap);
            simulationMap.setEntity((c), new Rock(c));
        }

        for (int i = 0; i < 2; i++) {
            Coordinates c = generateCoordinates(simulationMap);
            simulationMap.setEntity((c), new Tree(c));
        }

        for (int i = 0; i < 3; i++) {
            Coordinates c = generateCoordinates(simulationMap);
            simulationMap.setEntity((c), new Herbivore((c), 3, 100));
        }

        for (int i = 0; i < 2; i++) {
            Coordinates c = generateCoordinates(simulationMap);
            simulationMap.setEntity((c), new Predator((c), 2, 100));
        }


    }

    public Coordinates generateCoordinates(SimulationMap simulationMap) {
        Coordinates coordinates;

        do {
            coordinates = new Coordinates(random.nextInt(simulationMap.rowCount()), random.nextInt(simulationMap.columnCount()));
        } while (!simulationMap.isEmpty(coordinates));

        return coordinates;
    }

}
