package org.example;


public class Main {

    public static void main(String[] args) {

        SimulationMap simulationMap = new SimulationMap(5, 5);

        Simulation simulation = new Simulation(simulationMap);
        simulation.start();

    }
}

