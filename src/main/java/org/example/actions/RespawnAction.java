package org.example.actions;

import org.example.Coordinates;
import org.example.SimulationMap;
import org.example.SimulationMapUtils;
import org.example.entities.*;

import java.util.List;
import java.util.function.Function;

public class RespawnAction implements Action {
    private final int MAX_AREA_PER_GRASS = 9;
    private final int MAX_AREA_PER_ROCK = 9;
    private final int MAX_AREA_PER_TREE = 10;
    private final int MAX_AREA_PER_HERBIVORE = 10;
    private final int MAX_AREA_PER_PREDATOR = 14;

    private final int maxGrassAmount;
    private final int maxRockAmount;
    private final int maxTreeAmount;
    private final int maxHerbivoreAmount;
    private final int maxPredatorAmount;

    public RespawnAction(SimulationMap simulationMap) {
        int mapArea = simulationMap.height() * simulationMap.width();
        this.maxGrassAmount = mapArea / MAX_AREA_PER_GRASS;
        this.maxRockAmount = mapArea / MAX_AREA_PER_ROCK;
        this.maxTreeAmount = mapArea / MAX_AREA_PER_TREE;
        this.maxHerbivoreAmount = mapArea / MAX_AREA_PER_HERBIVORE;
        this.maxPredatorAmount = mapArea / MAX_AREA_PER_PREDATOR;

    }

    @Override
    public void execute(SimulationMap simulationMap) {      //checkAndAddEntities
        spawn(simulationMap, Grass.class, maxGrassAmount, c -> new Grass());
        spawn(simulationMap, Rock.class, maxRockAmount, c -> new Rock());
        spawn(simulationMap, Tree.class, maxTreeAmount, c -> new Tree());
        spawn(simulationMap, Herbivore.class, maxHerbivoreAmount, c -> new Herbivore(c));
        spawn(simulationMap, Predator.class, maxPredatorAmount, Predator::new);
    }

    private void spawn(SimulationMap simulationMap, Class<? extends Entity> clazz, int maxEntitiesAmount, Function<Coordinates, Entity> factory) {
        List<Entity> entities = simulationMap.getEntitiesByType(clazz);
        int currentEntitiesAmount = entities.size();
        if (currentEntitiesAmount < maxEntitiesAmount) {
            int amount = maxEntitiesAmount - currentEntitiesAmount;
            System.out.println("!!!prespawn");
            for (int i = 0; i < amount; i++) {
                Coordinates coordinates = SimulationMapUtils.generateCoordinates(simulationMap);
                Entity entity = factory.apply(coordinates);
                simulationMap.setEntity(coordinates, entity);
            }
        }
    }
}

