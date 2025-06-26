package org.example.entities;

import org.example.Coordinates;
import org.example.Obstacle;

public class Rock extends Entity implements Obstacle {
    public Rock(Coordinates coordinates) {
        super(coordinates);
    }

    @Override
    public boolean isPassable() {

        return false;
    }

    //статичные объекты
}
