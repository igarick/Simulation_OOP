package org.example.actions;

import org.example.Coordinates;
import org.example.SimulationMap;
import org.example.entities.Creature;
import org.example.entities.Entity;

import java.util.List;

import static org.example.searchPath.PathFinder.findPath;

public class MoveAction implements Actions{

    public void makeMove(SimulationMap simulationMap) {
        for (Entity entity : simulationMap.getEntities()) {
            if (entity instanceof Creature creature) {
                List<Coordinates> path = findPath(creature, simulationMap, creature.getTarget());
                creature.makeMove(simulationMap, path);
            }
        }
    }
}
