package org.example.entities;

import org.example.Coordinates;
import org.example.Obstacle;

public class Rock extends Entity implements Obstacle {
    public Rock(Coordinates coordinates) {
        super(coordinates);
    }

    @Override
    public boolean isAbilityToMove() {
        return false;
    }


    //статичные объекты
}
