package org.example;

import org.example.actions.InitAction;
import org.example.actions.ActAction;

public class Simulation {
    private final SimulationMap simulationMap;
    Renderer renderer = new Renderer();
    InitAction initAction = new InitAction();
    ActAction actAction = new ActAction();


    public Simulation(SimulationMap simulationMap) {
        this.simulationMap = simulationMap;
    }

    public void startSimulation() {
        initAction.placeEntities(simulationMap);

        while (true) {
            actAction.act(simulationMap, renderer);


        }
    }
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
