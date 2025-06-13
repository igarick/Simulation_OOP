package org.example.entities;

import org.example.Coordinates;

public class Grass extends Entity {
    public Grass(Coordinates coordinates) {
        super(coordinates);
    }

    @Override
    public boolean isAbilityToMove() {
        return false;
    }


    // ресурс для травоядных
}
