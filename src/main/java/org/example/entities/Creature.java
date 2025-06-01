package org.example.entities;

import org.example.Coordinates;

public abstract class Creature extends Entity {

    private final int speed;
    private int health;


    public Creature(Coordinates coordinates, int speed, int health) {
        super(coordinates);
        this.speed = speed;
        this.health = health;
    }
    //Абстрактный класс, наследуется от Entity.
    // Существо, имеет скорость (сколько клеток может пройти
    // за 1 ход), количество HP. Имеет метод makeMove() -
    // сделать ход.


}
