package org.example;

import org.example.entitiesUtils.Sprites;

public class Renderer {

    public void render(SimulationMap simulationMap) {
        for (int row = 0; row < simulationMap.height(); row++) {
            for (int column = 0; column < simulationMap.width(); column++) {
                Coordinates coordinates = new Coordinates(row, column);

                if (simulationMap.isEmpty(coordinates)) {
                    System.out.print("[" + Sprites.getGroundSprite() +"]");
                } else {
                    System.out.print("[" + Sprites.selectSprite(simulationMap.getEntity(coordinates)) + "]");
                }
            }
            System.out.println();
        }
    }
}


