package org.example;

import org.example.actions.MaintainAction;
import org.example.actions.EntitySpawnerAction;
import org.example.actions.MoveAction;

import java.io.IOException;
import java.util.Scanner;


public class Simulation {
    private final SimulationMap simulationMap;
    private final Renderer renderer = new Renderer();
    EntitySpawnerAction entitySpawnerAction = new EntitySpawnerAction();
    MoveAction moveAction = new MoveAction();
    MaintainAction maintainAction = new MaintainAction();
    private int counter;


    public Simulation(SimulationMap simulationMap) {
        this.simulationMap = simulationMap;
    }

    public void startSimulation() {
        entitySpawnerAction.spawnEntities(simulationMap);

        boolean paused = false; // пауза

        while (true) {
            try {
                if (System.in.available() > 0) {
                    Scanner scanner = new Scanner(System.in);
                    String input = scanner.nextLine().toLowerCase();

                    if (input.equals("")) {
                        paused = !paused;
                        System.out.println("Нажмите *Enter* чтобы продолжить");
                    }

                }

                if (!paused) {
                    nextTurn();
                }

                Thread.sleep(800);

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            } catch (IOException e) {
                System.err.println("Ошибка" + e.getMessage());
                break;
//                throw new RuntimeException(e);
            }

        }

    }

    public void nextTurn() {

        moveAction.makeMove(simulationMap);
        renderer.render(simulationMap);

//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            Thread.currentThread().interrupt();
//        }

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


//    Главный класс приложения, включает в себя:
//
//    Карту
//    Счётчик ходов
//    Рендерер поля
//    Actions - список действий, исполняемых перед
//    стартом симуляции или на каждом ходу (детали ниже)

//    Методы:
//
//    nextTurn() - просимулировать и отрендерить один ход
//    startSimulation() - запустить бесконечный цикл
//    симуляции и рендеринга
//    pauseSimulation() - приостановить бесконечный цикл
//    симуляции и рендеринга
}
