package org.example;

import org.example.TypeOfTarget.Prey;
import org.example.entities.*;
import org.example.searchPath.Path;

import java.util.List;

import static org.example.InteractionWithTarget.interactWithTargetNNNNN;

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
        renderer.renderer();

        System.out.println("------------------------------------------");

//        Creature creature = (Creature) simulationMap.getEntity(new Coordinates(0, 0));
//
//
//        List<Coordinates> path = Path.findPath(creature, simulationMap, creature::canEat);
//        for (Coordinates coordinates : path) {
//            System.out.println(coordinates);
//        }


        int step = 0;

        while (step < 4) {
            List<Creature> creatures = simulationMap.getEntitiesForMove();

            for (Creature creature : creatures) {

                List<Coordinates> pathToTarget = Path.findPath(creature, simulationMap, creature::isTarget);

//                if (pathToTarget.size() == 2) {
//                    Creature target = (Creature) simulationMap.getEntity(pathToTarget.get(1));
//                    if (target.isPrey() && target.getHealth() <= 50) {
//                        creature.makeMove(simulationMap, pathToTarget);
//                    } else if (target.isPrey() && target.getHealth() > 50) {
//                        creature.attack(target);
//                    }
//                }

//                InteractionWithTarget interaction = new InteractionWithTarget();
//
                if (pathToTarget.size() == 2) {         // путь до цели
                    Entity target = simulationMap.getEntity(pathToTarget.get(1));
                    interactWithTargetNNNNN(creature, target);  // взаимодействие с целью (нанесение урона / поедание травы)

                    if(target instanceof Prey) {        // если травоядное
                        Prey prey = (Prey) target;
                            if (!prey.isAlive()) {      // если погибло
                                creature.makeMove(simulationMap, pathToTarget);
                            } else {
                                break;
                            }
                    }

                    // check target after interaction - isAlive
                    //creature.makeMove(simulationMap, pathToTarget);

                } else {
                    creature.makeMove(simulationMap, pathToTarget);
                }



//                creature.makeMove(simulationMap, pathToTarget);
                renderer.renderer();

                try {
                    Thread.sleep(1500); // пауза для наглядности
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

//                if (pathToTarget.size() == 2) {
//                    creature.interactWithTarget();
//                }


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
