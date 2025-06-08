package org.example.entities;

import org.example.BreadthFirstSearch;
import org.example.Coordinates;
import org.example.Map;


//        // else -> look for Grass -> if find it -> move to Grass -> eat Grass
//        // if health > 50 -> look for available squares -> random move

public abstract class Creature extends Entity {

    private final int speed;
    private int health;

    public Creature(Coordinates coordinates, int speed, int health) {
        super(coordinates);
        this.speed = speed;
        this.health = health;
    }

    protected abstract void makeMove();

    public abstract boolean canMoveThrough(Entity entity);

    public int getSpeed() {
        return speed;
    }

    public abstract boolean canEat(Entity entity);
}





    //Абстрактный класс, наследуется от Entity.
    // Существо, имеет скорость (сколько клеток может пройти
    // за 1 ход), количество HP. Имеет метод makeMove() -
    // сделать ход.


