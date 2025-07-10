package org.example.entities;

import org.example.Coordinates;

public class Grass extends Entity{
    private final int healthRestoreAmount = 10;

    public int restoreHealth() {
        return healthRestoreAmount;
    }
}
