package org.example;

import org.example.entities.Entity;
import org.example.entities.Sprites;

public class Renderer {
//    Рендерер ответственен за визуализацию
//    состояния поля, его отрисовку


    public void renderer(Map map) {
        for (int row = 0; row <= FieldSize.ROW_COUNT; row++) {
            for (int column = 0; column <= FieldSize.COLUMN_COUNT; column++) {
                Coordinates coordinates = new Coordinates(row, column);

                if (map.isEmpty(coordinates)) {
                    System.out.print("[" + row + ".." + column + "]");
                } else {
                    System.out.print("[" + "." + getSpriteEntity(map.getEntity(coordinates)) + "."  + "]");
                }
            }
            System.out.println();
        }
    }

    private String getSpriteEntity(Entity entity) {
        return Sprites.selectUnicodeSprite(entity);
    }
}


