package org.example;

import org.example.entities.*;
import org.example.searchPath.Path;

import java.util.List;


public class Main {

    public static void main(String[] args) {

        SimulationMap simulationMap = new SimulationMap();

        simulationMap.setEntity(new Coordinates(1, 0),
                new Predator(new Coordinates(1, 0), 3, 0));

        simulationMap.setEntity(new Coordinates(0, 0),
                new Herbivore(new Coordinates(0, 0), 3, 99));
//
//        simulationMap.setEntity(new Coordinates(2, 0),
//                new Grass(new Coordinates(2, 0)));

//        gameMap.setEntity(new Coordinates(5, 4),
//                new Grass(new Coordinates(5, 4)));
//
        simulationMap.setEntity(new Coordinates(0, 1),
                new Rock(new Coordinates(0, 1)));
//
//        simulationMap.setEntity(new Coordinates(1, 1),
//                new Tree(new Coordinates(1, 1)));

        Renderer renderer = new Renderer(simulationMap);
        renderer.render();

        System.out.println("------------------------------------------");



        int step = 0;

        while (step < 4) {
            List<Creature> creatures = simulationMap.getEntitiesForMove();

            for (Creature creature : creatures) {
                List<Coordinates> pathToTarget = Path.findPath(creature, simulationMap, creature::isTarget);

                if (pathToTarget.size() == 2) {         // путь до цели
                    Entity target = simulationMap.getEntity(pathToTarget.get(1));
                    creature.interactWithTarget(target);




//                    if(target instanceof Prey) {        // если травоядное
//                        Prey prey = (Prey) target;
//                            if (!prey.isAlive()) {      // если погибло
//                                creature.makeMove(simulationMap, pathToTarget);
//                            } else {
//                                break;
//                            }
//                    }
                } else {
                    creature.makeMove(simulationMap);
                }

                renderer.render();

                try {
                    Thread.sleep(1500); // пауза для наглядности
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

                System.out.println(creature.getHealth());
            }

//
//            System.out.print("\033[H\033[2J");
//            System.out.flush();

//            renderer.renderer(simulationMap);
//
//            try {
//                Thread.sleep(1000); // пауза для наглядности
//            } catch (InterruptedException e) {
//                Thread.currentThread().interrupt();
//            }

            System.out.println("------------------------------------------");
            step++;
        }

    }

}
