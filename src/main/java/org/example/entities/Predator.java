package org.example.entities;

import org.example.Coordinates;
import org.example.Map;

import java.util.HashSet;
import java.util.Set;

public class Predator extends Creature {
    public Predator(Coordinates coordinates, int speed, int health) {
        super(coordinates, speed, health);
    }

    @Override
    protected void makeMove() {

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
