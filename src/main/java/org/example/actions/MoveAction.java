package org.example.actions;

import org.example.SimulationMap;
import org.example.entities.Creature;
import org.example.entities.Entity;

public class MoveAction implements Action {

    @Override
    public void execute(SimulationMap simulationMap) {
        for (Entity entity : simulationMap.getEntities()) {
            if (entity instanceof Creature creature) {
                if (creature.isAlive(simulationMap)) {
                    creature.makeMove(simulationMap);
                }
            }
        }
    }
}
