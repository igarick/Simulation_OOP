package org.example.entities;

import org.example.*;

import java.util.Optional;
import java.util.Set;

public class Herbivore extends Creature {
    public Herbivore(Coordinates coordinates, int speed, int health) {
        super(coordinates, speed, health);
    }

    @Override
    public void makeMove(Map map) {

        Optional<Coordinates> step = FirstStepToFood.findStep(this, map, this::canEat);

        if (step.isPresent()) {
            if (this.coordinates.equals(step.get())) {
                Set<Coordinates> neighborsCoordinates = MovementUtils.getReachableNeighbors(this.coordinates);
                for (Coordinates targetCoordinates : neighborsCoordinates) {
                    Entity entity = map.getEntity(targetCoordinates);
                    if (entity instanceof Grass) {
                        Move move = new Move(this.coordinates, targetCoordinates);
                        map.makeMove(move);
                        increaseHealth();
                    }
                }
            } else {
                Move move = new Move(this.coordinates, step.get());
                map.makeMove(move);
            }
        } else {
//            FirstStepToFood.findStep(this, map, e-> false);
//            FirstStepToFood
//            Coordinates move = getCoordinatesForMove;
//            Move move = new Move(this.coordinates, step.get());
//            map.makeMove(move);
        }

        //-------------------------------------------------
        // action
//
//        } else {
//            Coordinates move = getCoordinatesForMove;
//            map.removeEntity(this.coordinates,this);
//            map.setEntity(move, this);
//        }

    }

    protected void increaseHealth() {
        super.increaseHealth(10);
    }


//        FirstStepToFood.findStep(this.creature,);
    //Коза: если коор == текущей коор -> ищем в радиусе одной клетки траву -> съедаем
    //Тигр: если коор == текущей коор -> ищем в радиусе одной клетки Козу -> наносим урон

    //если если коор != текущей коор -> ход на коор

    //если если коор == 0 -> рандомный ход


    @Override
    public boolean canMoveThrough(Entity entity) {
        return !(entity instanceof Tree || entity instanceof Rock || entity instanceof Predator);
    }

    @Override
    public boolean canEat(Entity entity) {
        return entity instanceof Grass;
    }


    //Травоядное, наследуется от Creature.
    // Стремятся найти ресурс (траву),
    // может потратить свой ход на движение
    // в сторону травы, либо на её поглощение.
}
