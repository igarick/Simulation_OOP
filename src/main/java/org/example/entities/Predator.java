package org.example.entities;

import org.example.Coordinates;
import org.example.Obstacle;
import org.example.SimulationMap;

public class Predator extends Creature {
    public Predator(Coordinates coordinates, int speed, int health) {
        super(coordinates, speed, health);
    }

    @Override
    public void makeMove(SimulationMap simulationMap) {

    }


    // если Ячейка содержит Травоядное -> Хищник приближается к Травоядному
        // иначе Хищник двигается на макс расстояние,\



    @Override
    public boolean canMoveThrough(Entity entity) {
        return !(entity instanceof Obstacle || entity instanceof Grass || entity instanceof Predator);
    }

    @Override
    public boolean canEat(Entity entity) {
        return entity instanceof Herbivore;
    }

    @Override
    public boolean isAbilityToMove() {
        return true;
    }


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
