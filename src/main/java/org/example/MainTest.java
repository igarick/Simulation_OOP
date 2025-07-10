package org.example;

import org.example.actions.RespawnAction;

public class MainTest {
    public static void main(String[] args) {
        SimulationMap simulationMap = new SimulationMap(10,10);

        Renderer renderer = new Renderer();
        renderer.render(simulationMap);
        System.out.println(" ");

        RespawnAction respawnAction = new RespawnAction(simulationMap);
        respawnAction.execute(simulationMap);
        renderer.render(simulationMap);


    }
}
