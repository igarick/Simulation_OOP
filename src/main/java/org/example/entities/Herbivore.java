package org.example.entities;

import org.example.Coordinates;

public class Herbivore extends Creature {
    public Herbivore(Coordinates coordinates, int speed, int health) {
        super(coordinates, speed, health);
    }

    @Override
    protected void makeMove() {
        // if health > 50 -> look for available squares -> random move
        // else -> look for Grass -> if find it -> move to Grass -> eat Grass
    }

    //Травоядное, наследуется от Creature.
    // Стремятся найти ресурс (траву),
    // может потратить свой ход на движение
    // в сторону травы, либо на её поглощение.
}
