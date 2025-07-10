package org.example.actions;

import org.example.Coordinates;
import org.example.SimulationMap;
import org.example.entities.Creature;
import org.example.entities.Entity;
import org.example.entitiesUtils.AliveEntity;

import java.util.List;

import static org.example.searchPath.PathFinder.findPath;

public class MoveAction implements Actions {

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

//public void execute(SimulationMap simulationMap) {
//    for (Entity entity : simulationMap.getEntities()) {
////            if (entity instanceof AliveEntity aliveEntity) {
////                aliveEntity.tryMove(simulationMap);
////            }
//
//        if (entity instanceof Creature creature) {
//            if (creature.isAlive(simulationMap)) {
////                    Coordinates start = creature.getCoordinates();
//                creature.makeMove(simulationMap);
//            }
//        }
//    }
//}
