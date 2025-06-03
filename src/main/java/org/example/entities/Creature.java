package org.example.entities;

import org.example.Coordinates;
import org.example.Map;

import java.util.HashSet;
import java.util.Set;

public abstract class Creature extends Entity {

    private final int speed;
    private int health;


    public Creature(Coordinates coordinates, int speed, int health) {
        super(coordinates);
        this.speed = speed;
        this.health = health;
    }

    protected abstract void makeMove();

    public Set<Coordinates> getAvailableSquares(Map map) {
        Set<Coordinates> result = new HashSet<>();


        return result;
    }




//        // if health > 50 -> look for available squares -> random move
//        // else -> look for Grass -> if find it -> move to Grass -> eat Grass



    //Абстрактный класс, наследуется от Entity.
    // Существо, имеет скорость (сколько клеток может пройти
    // за 1 ход), количество HP. Имеет метод makeMove() -
    // сделать ход.


}
