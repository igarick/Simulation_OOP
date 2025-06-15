package org.example.entities;

import org.example.Coordinates;
import org.example.SimulationMap;


import java.util.List;


//        // else -> look for Grass -> if find it -> move to Grass -> eat Grass
//        // if health > 50 -> look for available squares -> random move

public abstract class Creature extends Entity {


    private final int speed;

    public void setHealth(int health) {
        this.health = health;
    }

    private int health;

    public Creature(Coordinates coordinates, int speed, int health) {
        super(coordinates);
        this.speed = speed;
        this.health = health;
    }

    public void makeMove(SimulationMap simulationMap, List<Coordinates> path) {
        if (path.size() > 2 && path.size() <= this.getSpeed()) {
            simulationMap.makeMove(this.coordinates, path.get(path.size() - 2));
        } else if (path.size() >= this.getSpeed()) {
            simulationMap.makeMove(this.coordinates, path.get(this.getSpeed()));
        } else if (path.size() == 2) {
            simulationMap.makeMove(this.coordinates, path.get(1));
        }
    }

//    protected void increaseHealth(int health) {
//        if (isHealthInBounds(health)) {
//            this.health += health;
//        } else {
//            this.health = 100;
//        }
//    }
//
//    protected boolean isHealthInBounds(int health) {
//        return !(this.health + health > 100);
//    }

    public abstract boolean canMoveThrough(Entity entity);

    public int getSpeed() {
        return speed;
    }

    public int getHealth() {
        return health;
    }

    public abstract boolean isTarget(Entity entity);

    public abstract void interactWithTarget();


}


//Абстрактный класс, наследуется от Entity.
// Существо, имеет скорость (сколько клеток может пройти
// за 1 ход), количество HP. Имеет метод makeMove() -
// сделать ход.


