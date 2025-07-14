package org.example;

import org.example.entities.Entity;
import org.example.entitiesUtils.Sprites;

public class Renderer {

    public void render(SimulationMap simulationMap) {
        for (int height = 0; height < simulationMap.height(); height++) {
            for (int wedth = 0; wedth < simulationMap.width(); wedth++) {
                Coordinates coordinates = new Coordinates(height, wedth);

                if (simulationMap.isEmpty(coordinates)) {
                    String groundSprite = Sprites.ground();
                    System.out.printf("[%s]",groundSprite);
                } else {
                    Entity entity = simulationMap.getEntity(coordinates);
                    String sprite = Sprites.selectSprite(entity);
                    System.out.printf("[%s]", sprite);
                }
            }
            System.out.println();
        }
    }
}


