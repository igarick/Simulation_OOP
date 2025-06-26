package org.example.entities;

import org.example.Coordinates;
import org.example.Obstacle;

public class Tree extends Entity implements Obstacle {
    public Tree(Coordinates coordinates) {
        super(coordinates);
    }

    @Override
    public boolean isPassable() {

        return false;
    }

    //статичные объекты
}
