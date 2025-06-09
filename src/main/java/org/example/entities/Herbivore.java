package org.example.entities;

import org.example.Coordinates;
import org.example.FirstStepToFood;
import org.example.Map;

public class Herbivore extends Creature {
    public Herbivore(Coordinates coordinates, int speed, int health) {
        super(coordinates, speed, health);
    }

    @Override
    protected void makeMove() {

//        FirstStepToFood.findStep(this.creature,);
        //Коза: если коор == текущей коор -> ищем в радиусе одной клетки траву -> съедаем
        //Тигр: если коор == текущей коор -> ищем в радиусе одной клетки Козу -> наносим урон

        //если если коор != текущей коор -> ход на коор

        //если если коор == 0 -> рандомный ход

    }

    @Override
    public boolean canMoveThrough(Entity entity) {
        return !(entity instanceof Tree || entity instanceof Rock);
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
