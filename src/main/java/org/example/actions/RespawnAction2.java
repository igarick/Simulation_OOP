package org.example.actions;

import org.example.Coordinates;
import org.example.Renderer;
import org.example.SimulationMap;
import org.example.SimulationMapUtils;
import org.example.entities.*;

import java.util.List;
import java.util.function.Function;

public class RespawnAction2 implements Action {
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

    private boolean flagRespawn;

    private final Renderer renderer;

    public RespawnAction2(SimulationMap simulationMap, Renderer renderer) {
        int mapArea = simulationMap.height() * simulationMap.width();
        this.maxGrassAmount = mapArea / MAX_AREA_PER_GRASS;
        this.maxRockAmount = mapArea / MAX_AREA_PER_ROCK;
        this.maxTreeAmount = mapArea / MAX_AREA_PER_TREE;
        this.maxHerbivoreAmount = mapArea / MAX_AREA_PER_HERBIVORE;
        this.maxPredatorAmount = mapArea / MAX_AREA_PER_PREDATOR;
        this.renderer = renderer;

    }

    @Override
    public void execute(SimulationMap simulationMap) {
        flagRespawn = false;
        spawn(simulationMap, Grass.class, maxGrassAmount, c -> new Grass());
        spawn(simulationMap, Rock.class, maxRockAmount, c -> new Rock());
        spawn(simulationMap, Tree.class, maxTreeAmount, c -> new Tree());
        spawn(simulationMap, Herbivore.class, maxHerbivoreAmount, c -> new Herbivore(c));
        spawn(simulationMap, Predator.class, maxPredatorAmount, Predator::new);
        if (flagRespawn) {
            pause();
            renderer.render(simulationMap);
        }
    }

    private void spawn(SimulationMap simulationMap, Class<? extends Entity> clazz, int maxEntitiesAmount, Function<Coordinates, Entity> factory) {
        List<Entity> entities = simulationMap.getEntitiesByType(clazz);
        int currentEntitiesAmount = entities.size();
        if (currentEntitiesAmount < maxEntitiesAmount) {
            flagRespawn = true;
            int amount = maxEntitiesAmount - currentEntitiesAmount;
            System.out.println("!!!prespawn");
            for (int i = 0; i < amount; i++) {
                Coordinates coordinates = SimulationMapUtils.generateCoordinates(simulationMap);
                Entity entity = factory.apply(coordinates);
                simulationMap.setEntity(coordinates, entity);
            }
        }
    }

    private void pause() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

