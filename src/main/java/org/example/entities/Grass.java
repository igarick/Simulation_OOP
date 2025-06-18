package org.example.entities;

import org.example.Coordinates;
//import org.example.TypeOfTarget.Food;

public class Grass extends Entity{
    private final int healthRestoreAmount = 10;

    public Grass(Coordinates coordinates) {
        super(coordinates);
    }

    @Override
    public boolean isAbilityToMove() {
        return false;
    }

    public int getHealthRestoreAmount() {
        return healthRestoreAmount;
    }

    public int restoreHealth() {
        return healthRestoreAmount;
    }


    // ресурс для травоядных
}
