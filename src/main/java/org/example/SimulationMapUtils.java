package org.example;

import java.util.Random;

public final class SimulationMapUtils {
    private final static Random RANDOM = new Random();

    private SimulationMapUtils() {
    }

    public static Coordinates generateCoordinates(SimulationMap simulationMap) {
        Coordinates coordinates;

        do {
            coordinates = new Coordinates(RANDOM.nextInt(simulationMap.height()), RANDOM.nextInt(simulationMap.width()));
        } while (!simulationMap.isEmpty(coordinates));

        return coordinates;
    }
}
