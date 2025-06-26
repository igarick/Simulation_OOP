package org.example.actions;

import org.example.SimulationMap;
import org.example.entities.*;

import java.util.List;

public class MaintainAction implements Actions {
    private final EntitySpawnerAction entitySpawnerAction = new EntitySpawnerAction();

    public void checkAndAddEntities(SimulationMap simulationMap) {
        int mapArea = simulationMap.rowCount() * simulationMap.columnCount();

        List<Entity> grass = simulationMap.getEntityByType(Grass.class);
        if (mapArea / grass.size() >= 10) {
            entitySpawnerAction.placeEntitiesRandomly(simulationMap, 2, Grass::new);
        }

        List<Entity> rock = simulationMap.getEntityByType(Rock.class);
        if (mapArea / rock.size() >= 10) {
            entitySpawnerAction.placeEntitiesRandomly(simulationMap, 1, Rock::new);
        }

        List<Entity> tree = simulationMap.getEntityByType(Tree.class);
        if (mapArea / tree.size() > 10) {
            entitySpawnerAction.placeEntitiesRandomly(simulationMap, 1, Tree::new);
        }

        List<Entity> herbivore = simulationMap.getEntityByType(Herbivore.class);
        if (mapArea / herbivore.size() > 10) {
            entitySpawnerAction.placeEntitiesRandomly(simulationMap, 1, c -> new Herbivore(c, 3, 100));
        }

        List<Entity> predator = simulationMap.getEntityByType(Predator.class);
        if (mapArea / predator.size() >= 15) {
            entitySpawnerAction.placeEntitiesRandomly(simulationMap, 1, c -> new Predator(c, 2, 100));
        }

    }
}
