package org.example;

import org.example.entities.Entity;
import org.example.entities.Sprites;

public class Renderer {
//    Рендерер ответственен за визуализацию
//    состояния поля, его отрисовку
    private final SimulationMap simulationMap;

    public Renderer(SimulationMap simulationMap) {
        this.simulationMap = simulationMap;
    }


    public void renderer() {
        for (int row = 0; row < simulationMap.rowCount(); row++) {
            for (int column = 0; column < simulationMap.columnCount(); column++) {
                Coordinates coordinates = new Coordinates(row, column);

                if (simulationMap.isEmpty(coordinates)) {
                    System.out.print("[" + row + ".." + column + "]");
                } else {
//                    System.out.print("[" + "." + getSpriteEntity(simulationMap.getEntity(coordinates)) + "."  + "]");
                    System.out.print("[" + "." + Sprites.selectSprite(simulationMap.getEntity(coordinates)) + "."  + "]");

                }
            }
            System.out.println();
        }
    }
//
//    private String getSpriteEntity(Entity entity) {
//        return Sprites.selectSprite(entity);
//    }
}


