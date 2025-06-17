package org.example.entities;

import org.example.Coordinates;
import org.example.Obstacle;
//import org.example.TypeOfTarget.Hunter;
//import org.example.TypeOfTarget.Prey;

public class Predator extends Creature {
    private final int damage = 50;


    public Predator(Coordinates coordinates, int speed, int health) {
        super(coordinates, speed, health);
    }



    // если Ячейка содержит Травоядное -> Хищник приближается к Травоядному
        // иначе Хищник двигается на макс расстояние,\

    @Override
    public boolean canMoveThrough(Entity entity) {
        return !(entity instanceof Obstacle || entity instanceof Grass || entity instanceof Predator);
    }

    @Override
    public boolean isTarget(Entity entity) {
        return entity instanceof Herbivore;
    }

    @Override
    public boolean isAbilityToMove() {
        return true;
    }

    @Override
    public void interactWithTarget(Entity entity) {

        if (entity instanceof Herbivore herbivore) {
            attack(herbivore);
            if (prey.isSurvived(damage)) {
                prey.adjustHealth(-damage);
            } else {
                prey.dropToMinHealth(prey.getHealthMin());
            }
        }
    }

    private void attack(Herbivore herbivore) {
        prey.takeDamage(damage);
    }

    @Override
    public boolean isPrey() {
        return false;
    }

    //---------------------------Hunter------------
//    @Override
//    public int getDamage() {
//        return damage;
//    }
    //---------------------------Hunter------------

    //Хищник, наследуется от Creature.
        // В дополнение к полям класса Creature,
        // имеет силу атаки. На что может потратить
        // ход хищник:
        //Переместиться (чтобы приблизиться к жертве -
        // травоядному)
        //Атаковать травоядное. При этом количество HP
        // травоядного уменьшается на силу атаки хищника.
        // Если значение HP жертвы опускается до 0,
        // травоядное исчезает

}
