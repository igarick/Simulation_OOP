package org.example.entities;

import org.example.Coordinates;
import org.example.Obstacle;
import org.example.SimulationMap;
//import org.example.TypeOfTarget.Prey;
//import org.example.dao.Eat;
//import org.example.TypeOfTarget.Hunter;
//import org.example.TypeOfTarget.Prey;

public class Predator extends Creature {
    private final int damage = 50;
    private final Class<? extends Entity> target = Herbivore.class;


    public Predator(Coordinates coordinates, int speed, int health) {
        super(coordinates, speed, health);
    }

    @Override
    public Class<? extends Entity> getTarget() {
        return target;
    }


    // если Ячейка содержит Травоядное -> Хищник приближается к Травоядному
        // иначе Хищник двигается на макс расстояние,\

    @Override
    public boolean canMoveThrough(Entity entity) {
        return !(entity instanceof Obstacle || entity instanceof Grass || entity instanceof Predator);
    }
//
//    @Override
//    public boolean isTarget(Entity entity) {
//        return entity instanceof Herbivore;
//    }


    @Override
    public void interactWithTarget(Entity entity) {

        if (entity instanceof Herbivore herbivore) {
            attack(herbivore);
        }
    }

    private void attack(Herbivore herbivore) {
        herbivore.takeDamage(damage);
    }

    @Override
    public boolean isPrey() {
        return false;
    }

    @Override
    public boolean isAlive(SimulationMap simulationMap) {
        return true;
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
