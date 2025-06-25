package org.example;

import org.example.actions.EntitySpawner;
import org.example.actions.InitAction;
import org.example.actions.ActAction;
import org.example.entities.Entity;

public class Simulation {
    private final SimulationMap simulationMap;
    private final Renderer renderer = new Renderer();
    InitAction initAction = new InitAction();
    ActAction actAction = new ActAction();
    EntitySpawner entitySpawner = new EntitySpawner();


    public Simulation(SimulationMap simulationMap) {
        this.simulationMap = simulationMap;
    }

    public void startSimulation() {
        initAction.createEntity(simulationMap);

        while (true) {
            actAction.act(this, simulationMap, renderer);
            entitySpawner.checkAndAddEntities(simulationMap);

        }
    }

    public void makeMove(Coordinates from, Coordinates to) {
        Entity entity = this.simulationMap.getEntity(from);

        this.simulationMap.removeEntity(from);
        this.simulationMap.setEntity(to, entity);
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
