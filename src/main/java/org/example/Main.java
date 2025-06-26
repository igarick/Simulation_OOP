package org.example;


public class Main {

    public static void main(String[] args) {

        SimulationMap simulationMap = new SimulationMap(7, 7);

        Simulation simulation = new Simulation(simulationMap);
        simulation.startSimulation();

    }
}

