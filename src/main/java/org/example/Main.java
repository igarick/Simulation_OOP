package org.example;

import org.example.entities.*;
import org.example.searchPath.Path;

import java.util.Iterator;
import java.util.List;


public class Main {

    private static Class<? extends Entity> Creature;

    public static void main(String[] args) {

        SimulationMap simulationMap = new SimulationMap();

        simulationMap.setEntity(new Coordinates(3, 0),
                new Predator(new Coordinates(3, 0), 3, 100));

        simulationMap.setEntity(new Coordinates(0, 0),
                new Herbivore(new Coordinates(0, 0), 3, 59));
        simulationMap.setEntity(new Coordinates(5, 0),
                new Herbivore(new Coordinates(5, 0), 3, 59));

        simulationMap.setEntity(new Coordinates(5, 4),
                new Grass(new Coordinates(5, 4)));

        simulationMap.setEntity(new Coordinates(0, 3),
                new Grass(new Coordinates(0, 3)));

//
        simulationMap.setEntity(new Coordinates(0, 1),
                new Rock(new Coordinates(0, 1)));
//
        simulationMap.setEntity(new Coordinates(3, 1),
                new Tree(new Coordinates(3, 1)));

        simulationMap.setEntity(new Coordinates(2, 3),
                new Tree(new Coordinates(2, 3)));

        simulationMap.setEntity(new Coordinates(3, 3),
                new Tree(new Coordinates(3, 3)));
        simulationMap.setEntity(new Coordinates(4, 3),
                new Tree(new Coordinates(4, 3)));

        Renderer renderer = new Renderer(simulationMap);
        renderer.render();

        System.out.println("------------------------------------------");



        int step = 0;

        while (step < 10) {

            List<Creature> creatures = simulationMap.getEntitiesForMove();
            Iterator<Creature> list = creatures.iterator();


            for (Creature creature : creatures) {
                if (!creature.isAlive(simulationMap)) {
                    //simulationMap.removeEntity(creature.coordinates);
                    continue;
                }
                    List<Coordinates> path = Path.findPath(creature, simulationMap, creature.getTarget());    //creature::isTarget
                    Move move = creature.getCoordinatesForMove(simulationMap, path);
                    simulationMap.makeMove(move.from, move.to);


                    renderer.render();

                    try {
                        Thread.sleep(500); // пауза для наглядности
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }

                    System.out.println(creature.getClass() + " : " + creature.getHealth());

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

