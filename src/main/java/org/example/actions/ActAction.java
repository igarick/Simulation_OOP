package org.example.actions;

import org.example.Coordinates;
import org.example.Renderer;
import org.example.Simulation;
import org.example.SimulationMap;
import org.example.entities.Creature;
import org.example.entities.Entity;
import org.example.searchPath.Path;

import java.util.List;

public class ActAction {

    public void act(Simulation simulation ,SimulationMap simulationMap, Renderer renderer) {
        for (Entity entity : simulationMap.getEntities()) {
            if (entity instanceof Creature creature) {
                List<Coordinates> path = Path.findPath(creature, simulationMap, creature.getTarget());
                creature.makeMove(simulation, simulationMap, path);
                renderer.render(simulationMap);
                System.out.println(creature.getClass().getName() + creature.getHealth());
                System.out.println("-------------------------------------------");

                try {
                    Thread.sleep(500); // пауза для наглядности
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

            }
        }
    }

}
