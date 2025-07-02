package org.example;

import org.example.actions.MaintainAction;
import org.example.actions.EntitySpawnerAction;
import org.example.actions.MoveAction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Simulation {
    private final SimulationMap simulationMap;
    private final Renderer renderer = new Renderer();

    private final EntitySpawnerAction entitySpawnerAction = new EntitySpawnerAction();
    private final MoveAction moveAction = new MoveAction();
    private final MaintainAction maintainAction = new MaintainAction();

    private int counter;
    private final Scanner scanner = new Scanner(System.in);



    public Simulation(SimulationMap simulationMap) {
        this.simulationMap = simulationMap;
    }

    public void startSimulation() {
        entitySpawnerAction.spawnEntities(simulationMap);
        System.out.println("Симуляция запущена");

        boolean paused = false;

        while (true) {
            try {
                if (System.in.available() > 0) {
                    String input = scanner.nextLine().toLowerCase();
                    if (input.equals("p")) {
                        paused = !paused;
                        System.out.println(paused ? "*Симуляция приостановлена* для продолжения нажмите *p* затем Enter" : "Симуляция продолжается");
                    } else {
                        System.out.println("Неизвестная команда. Нажмите *p* и затем Enter для включения / выключения паузы");
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            if (!paused) {
                nextTurn();
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void nextTurn() {
        moveAction.makeMove(simulationMap);
        renderer.render(simulationMap);

        System.out.print("\033[H\033[2J");
        System.out.flush();

        counter++;
        System.out.println("\n Количество ходов : " + counter + "\n");

        maintainAction.checkAndAddEntities(simulationMap);
    }

//    public void makeMove(Coordinates from, Coordinates to) {
//        Entity entity = this.simulationMap.getEntity(from);
//
//        this.simulationMap.removeEntity(from);
//        this.simulationMap.setEntity(to, entity);
//    }

}
