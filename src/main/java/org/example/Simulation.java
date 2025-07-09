package org.example;

import org.example.actions.Actions;
import org.example.actions.MaintainAction;
import org.example.actions.EntitySpawnerAction;
import org.example.actions.MoveAction;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;


public class Simulation {
    private final SimulationMap simulationMap;
    private final Renderer renderer = new Renderer();

    private final EntitySpawnerAction entitySpawnerAction = new EntitySpawnerAction();
    private final MoveAction moveAction = new MoveAction();
    private final MaintainAction maintainAction = new MaintainAction();

    private final List<Actions> initActions;
    private final List<Actions> turnActions;

    private int counter;
    private final Scanner scanner = new Scanner(System.in);

    private static final String PAUSE = "p";



    public Simulation(SimulationMap simulationMap) {
        this.simulationMap = simulationMap;
        this.initActions = List.of(new EntitySpawnerAction());
        this.turnActions = List.of(new MoveAction(), new MaintainAction());
    }

    public void start() {
        executeActions(initActions);

//        entitySpawnerAction.spawnEntities(simulationMap);
        System.out.println("Симуляция запущена");


        boolean empty = simulationMap.isEmpty(new Coordinates(7, 7));
        System.out.println(empty);
        renderer.render(simulationMap);
        System.out.println("------------------------------------");



        boolean paused = false;

        while (true) {
            try {
                if (System.in.available() > 0) {
                    String input = scanner.nextLine().toLowerCase();
                    if (input.equals(PAUSE)) {
                        paused = !paused;
                        System.out.printf(paused ? "*Симуляция приостановлена* для продолжения " +
                                "нажмите '%s' затем 'Enter'" : "Симуляция продолжается \n", PAUSE);
                    } else {
                        System.out.printf("Неизвестная команда. Нажмите '%s' и затем 'Enter' для включения / выключения паузы \n", PAUSE);
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

    private void nextTurn() {
        executeActions(turnActions);

//        moveAction.makeMove(simulationMap);
        renderer.render(simulationMap);

        counter++;
        System.out.println("\n Количество ходов : " + counter + "\n");

      //  maintainAction.checkAndAddEntities(simulationMap);
    }

    private void executeActions(List<Actions> actions) {
        for (Actions a : actions) {
            a.execute(simulationMap);
        }
    }
}
