package org.example.entities;

import org.example.Coordinates;
import org.example.FirstStepToFood;
import org.example.Map;
import org.example.MovementUtils;

import java.util.Optional;
import java.util.Set;


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

    public void makeMove(Map map){}
//        Optional<Coordinates> step = FirstStepToFood.findStep(this, map);
//
//
//        if (step.isPresent()) {
//            if (this.coordinates.equals(step.get())) {
//                Set<Coordinates> neighbors = MovementUtils.getReachableNeighbors(this.coordinates);
//                // action
//            } else {
//                map.removeEntity(this.coordinates, this);
//                map.setEntity(step.get(), this);
//            }
//        } else {
//            Coordinates move = getCoordinatesForMove;
//            map.removeEntity(this.coordinates,this);
//            map.setEntity(move, this);
//        }

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


        //Коза: если коор == текущей коор -> ищем в радиусе одной клетки траву -> съедаем
        //Тигр: если коор == текущей коор -> ищем в радиусе одной клетки Козу -> наносим урон

        //если если коор != текущей коор -> ход на коор

        //если если коор == 0 -> рандомный ход

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


