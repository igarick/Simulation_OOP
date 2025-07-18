package org.example;

import org.example.actions.*;
import org.example.actions.RespawnAction;
import org.example.actions.InitialSpawnAction;
import org.example.actions.MoveAction;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;


public class Simulation {
    private final SimulationMap simulationMap;
    private final Renderer renderer = new Renderer();

    private final InitialSpawnAction initialSpawnAction = new InitialSpawnAction();

    private final List<Action> initActions;
    private final List<Action> turnActions;
    private final Action moveAction;
    private final Action respawnAction;

    private int counter;
    private final Scanner scanner = new Scanner(System.in);

    private static final String PAUSE = "p";

    public Simulation(SimulationMap simulationMap) {
        this.simulationMap = simulationMap;
        this.initActions = List.of(new InitialSpawnAction());
        this.turnActions = List.of(new MoveAction(), new RespawnAction(simulationMap));
        this.moveAction = new MoveAction();
        this.respawnAction = new RespawnAction2(simulationMap, renderer);
    }

    public void start() {
        executeActions(initActions);

        System.out.println("Симуляция запущена");

        renderer.render(simulationMap);
        System.out.println("---------------------");

        boolean paused = false;

        while (true) {
            try {
                if (System.in.available() > 0) {
                    String input = scanner.nextLine().toLowerCase();
                    if (input.equals(PAUSE)) {
                        paused = !paused;
                        System.out.printf(paused ? "*Симуляция приостановлена* для продолжения " +
                                "нажмите '%s' затем Enter" : "Симуляция продолжается \n", PAUSE);
                    } else {
                        System.out.printf("Неизвестная команда. Нажмите '%s' и затем Enter для " +
                                "включения / выключения паузы \n", PAUSE);
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            if (!paused) {
                nextTurn();
            }
            pause();
        }
    }

    private void nextTurn() {
//        executeActions(turnActions);

        moveAction.execute(simulationMap);
        renderer.render(simulationMap);
        respawnAction.execute(simulationMap);

        counter++;
        System.out.println("\n Количество ходов : " + counter + "\n");
    }

    private void executeActions(List<Action> actions) {
        for (Action a : actions) {
            a.execute(simulationMap);
        }
    }

    private void pause() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
