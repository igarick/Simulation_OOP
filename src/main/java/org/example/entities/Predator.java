package org.example.entities;

import org.example.Coordinates;

public class Predator extends Creature {
    public Predator(Coordinates coordinates, int speed, int health) {
        super(coordinates, speed, health);
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
