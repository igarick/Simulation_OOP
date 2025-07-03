package org.example.actions;

import org.example.SimulationMap;
import org.example.entities.*;

import java.util.List;

public class MaintainAction implements Actions {
    private final EntitySpawnerAction entitySpawnerAction = new EntitySpawnerAction();

    public void checkAndAddEntities(SimulationMap simulationMap) {
        int mapArea = simulationMap.rowCount() * simulationMap.columnCount();

        List<Entity> grasses = simulationMap.getEntitiesByType(Grass.class);
        if (mapArea / grasses.size() >= 10) {
            entitySpawnerAction.placeEntitiesRandomly(simulationMap, 3, Grass::new);
        }

        List<Entity> rocks = simulationMap.getEntitiesByType(Rock.class);
        if (mapArea / rocks.size() >= 10) {
            entitySpawnerAction.placeEntitiesRandomly(simulationMap, 1, Rock::new);
        }

        List<Entity> trees = simulationMap.getEntitiesByType(Tree.class);
        if (mapArea / trees.size() > 10) {
            entitySpawnerAction.placeEntitiesRandomly(simulationMap, 1, Tree::new);
        }

        List<Entity> herbivores = simulationMap.getEntitiesByType(Herbivore.class);
        if (mapArea / herbivores.size() > 10) {
            entitySpawnerAction.placeEntitiesRandomly(simulationMap, 1, c -> new Herbivore(c, 3, 100));
        }

        List<Entity> predators = simulationMap.getEntitiesByType(Predator.class);
        if (mapArea / predators.size() >= 15) {
            entitySpawnerAction.placeEntitiesRandomly(simulationMap, 1, c -> new Predator(c, 2, 100));
        }

    }
}
