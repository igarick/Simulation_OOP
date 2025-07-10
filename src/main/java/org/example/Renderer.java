package org.example;

import org.example.entitiesUtils.Sprites;

public class Renderer {

    public void render(SimulationMap simulationMap) {
        for (int height = 0; height < simulationMap.height(); height++) {
            for (int wedth = 0; wedth < simulationMap.width(); wedth++) {
                Coordinates coordinates = new Coordinates(height, wedth);

                if (simulationMap.isEmpty(coordinates)) {
                    System.out.print("[" + Sprites.ground() +"]");
//                    System.out.print("[" + height + Sprites.ground() + wedth + "]");
                } else {
                    System.out.print("[" + Sprites.selectSprite(simulationMap.getEntity(coordinates)) + "]");
//                    System.out.print("["+ height + Sprites.selectSprite(simulationMap.getEntity(coordinates)) +wedth +  "]");
                }
            }
            System.out.println();
        }
    }
}


