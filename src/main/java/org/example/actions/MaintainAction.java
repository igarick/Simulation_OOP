package org.example.actions;

import org.example.Coordinates;
import org.example.SimulationMap;
import org.example.entities.*;

import java.util.List;
import java.util.function.Function;

public class MaintainAction implements Actions {
    private final EntitySpawnerAction entitySpawnerAction = new EntitySpawnerAction();

    private final int MAX_AREA_PER_GRASS = 9;
    private final int MAX_AREA_PER_ROCK = 9;
    private final int MAX_AREA_PER_TREE = 10;
    private final int MAX_AREA_PER_HERBIVORE = 10;
    private final int MAX_AREA_PER_PREDATOR = 14;

    private final int GRASS_SPAWN_COUNT = 3;
    private final int DEFAULT_SPAWN_COUNT = 1;

    @Override
    public void execute(SimulationMap simulationMap) {      //checkAndAddEntities
        int mapArea = simulationMap.height() * simulationMap.width();

        spawn(simulationMap, Grass.class, mapArea, MAX_AREA_PER_GRASS, _ -> new Grass());
        spawn(simulationMap, Rock.class, mapArea, MAX_AREA_PER_ROCK, _ -> new Rock());
        spawn(simulationMap, Tree.class, mapArea, MAX_AREA_PER_TREE, _ -> new Tree());
        spawn(simulationMap, Herbivore.class, mapArea, MAX_AREA_PER_HERBIVORE, Herbivore::new);
        spawn(simulationMap, Predator.class, mapArea, MAX_AREA_PER_PREDATOR, Predator::new);
    }

    private void spawn(SimulationMap simulationMap, Class<? extends Entity> clazz, int mapArea, int limit, Function<Coordinates, Entity> factory) {
//        List<Entity> entities = simulationMap.getEntitiesByType(clazz);
//
//        int spawnEntityCount;
//
//        if (clazz == Grass.class) {
//            spawnEntityCount = GRASS_SPAWN_COUNT;
//        } else {
//            spawnEntityCount = DEFAULT_SPAWN_COUNT;
//        }
//
//        if ((entities.isEmpty()) || (mapArea / entities.size() > limit)) {
//            entitySpawnerAction.placeEntitiesRandomly(simulationMap, spawnEntityCount, factory);
//        }
    }
//        List<Entity> grasses = simulationMap.getEntitiesByType(Grass.class);
//        if (mapArea / grasses.size() >= 10) {
//            entitySpawnerAction.placeEntitiesRandomly(simulationMap, 3, _ -> new Grass());

//        }
//        List<Entity> rocks = simulationMap.getEntitiesByType(Rock.class);
//        if (mapArea / rocks.size() >= 10) {
//            entitySpawnerAction.placeEntitiesRandomly(simulationMap, 1, _ -> new Rock());

//        }
//        List<Entity> trees = simulationMap.getEntitiesByType(Tree.class);
//        if (mapArea / trees.size() > 10) {
//            entitySpawnerAction.placeEntitiesRandomly(simulationMap, 1, _ -> new Tree());

//        }
//        List<Entity> herbivores = simulationMap.getEntitiesByType(Herbivore.class);
//        if (mapArea / herbivores.size() > 10) {
//            entitySpawnerAction.placeEntitiesRandomly(simulationMap, 1, c -> new Herbivore(c, 3, 100));
//        }
//
//        List<Entity> predators = simulationMap.getEntitiesByType(Predator.class);
//        if (mapArea / predators.size() >= 15) {
//            entitySpawnerAction.placeEntitiesRandomly(simulationMap, 1, c -> new Predator(c, 2, 100));
//        }

//


}
