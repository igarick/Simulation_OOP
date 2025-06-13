package org.example.entities;

import org.example.Coordinates;
import org.example.SimulationMap;


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

    public void makeMove(SimulationMap simulationMap){
    }

    protected void increaseHealth(int health) {
        if (isHealthInBounds(health)) {
            this.health += health;
        } else {
            this.health = 100;
        }
    }

    protected boolean isHealthInBounds(int health) {
        return !(this.health + health > 100);
    }

        public abstract boolean canMoveThrough (Entity entity);

        public int getSpeed () {
            return speed;
        }

        public int getHealth() {
            return health;
        }

        public abstract boolean canEat (Entity entity);
    }






    //Абстрактный класс, наследуется от Entity.
    // Существо, имеет скорость (сколько клеток может пройти
    // за 1 ход), количество HP. Имеет метод makeMove() -
    // сделать ход.


