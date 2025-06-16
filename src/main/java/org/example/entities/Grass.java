package org.example.entities;

import org.example.Coordinates;
import org.example.TypeOfTarget.Food;

public class Grass extends Entity implements Food {
    private final int healthRestoreAmount = 10;

    public Grass(Coordinates coordinates) {
        super(coordinates);
    }

    @Override
    public boolean isAbilityToMove() {
        return false;
    }

    @Override
    public int getHealthRestoreAmount() {
        return healthRestoreAmount;
    }


    // ресурс для травоядных
}
