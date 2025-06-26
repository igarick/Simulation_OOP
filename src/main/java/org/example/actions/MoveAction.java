package org.example.actions;

import org.example.Coordinates;
import org.example.SimulationMap;
import org.example.entities.Creature;
import org.example.entities.Entity;
import org.example.searchPath.Path;

import java.util.List;

public class MoveAction implements Actions{

    public void makeMove(SimulationMap simulationMap) {
        for (Entity entity : simulationMap.getEntities()) {
            if (entity instanceof Creature creature) {
                List<Coordinates> path = Path.findPath(creature, simulationMap, creature.getTarget());
                creature.makeMove(simulationMap, path);
            }
        }
    }
}
