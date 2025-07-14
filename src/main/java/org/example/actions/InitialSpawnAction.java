package org.example.actions;

import org.example.Coordinates;
import org.example.SimulationMap;
import org.example.SimulationMapUtils;
import org.example.entities.*;

import java.util.Random;
import java.util.function.Function;

public class InitialSpawnAction implements Action {
    private final int DEFAULT_ENTITIES_AMOUNT = 3;

    private final Random random = new Random();

    @Override
    public void execute(SimulationMap simulationMap) {        //spawnEntities
        placeEntitiesRandomly(simulationMap, _ -> new Grass());
        placeEntitiesRandomly(simulationMap, _ -> new Rock());
        placeEntitiesRandomly(simulationMap, _ -> new Tree());
        placeEntitiesRandomly(simulationMap, Predator::new);
        placeEntitiesRandomly(simulationMap, Herbivore::new);
    }

    private void placeEntitiesRandomly(SimulationMap simulationMap, Function<Coordinates, Entity> factory) { //Function<Coordinates, Entity> factory
        for (int i = 0; i < DEFAULT_ENTITIES_AMOUNT; i++) {
            Coordinates c = SimulationMapUtils.generateCoordinates(simulationMap);
            simulationMap.setEntity(c,factory.apply(c));
        }
    }

}
