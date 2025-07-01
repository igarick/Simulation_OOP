package org.example;

import org.example.entitiesUtils.Sprites;

public class Renderer {

    public void render(SimulationMap simulationMap) {
        for (int row = 0; row < simulationMap.rowCount(); row++) {
            for (int column = 0; column < simulationMap.columnCount(); column++) {
                Coordinates coordinates = new Coordinates(row, column);

                if (simulationMap.isEmpty(coordinates)) {
                    System.out.print("[" + row + ".." + column + "]");
                } else {
                    System.out.print("[" + "." + Sprites.selectSprite(simulationMap.getEntity(coordinates)) + "."  + "]");
                }
            }
            System.out.println();
        }
    }
}


