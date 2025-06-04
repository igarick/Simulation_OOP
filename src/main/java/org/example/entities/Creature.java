package org.example.entities;

import org.example.BreadthFirstSearch;
import org.example.Coordinates;
import org.example.Map;

import java.util.HashSet;
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

    protected abstract void makeMove();


    protected Set<CoordinatesShift> availableShifts() {
        Set<CoordinatesShift> result = new HashSet<>();

        result.add(new CoordinatesShift(0, 1));
        result.add(new CoordinatesShift(0, -1));
        result.add(new CoordinatesShift(1, 0));
        result.add(new CoordinatesShift(-1, 0));

        return result;
    }

    public Set<Coordinates> getVertexes(Map map) {
        Set<Coordinates> allAvailableVertexes = new HashSet<>();

        for (CoordinatesShift shift : availableShifts()) {
            if (coordinates.canShift(shift)) {
                Coordinates newCoordinates = coordinates.shift(shift);

                if(availableVertex(newCoordinates, map)) {
                    allAvailableVertexes.add(newCoordinates);
                }
            }
        }
        return allAvailableVertexes;
    }

    protected boolean availableVertex(Coordinates coordinates, Map map) {
        return ((map.isEmpty(coordinates)) && !BreadthFirstSearch.getVisited().contains(coordinates));
    }
}





    //Абстрактный класс, наследуется от Entity.
    // Существо, имеет скорость (сколько клеток может пройти
    // за 1 ход), количество HP. Имеет метод makeMove() -
    // сделать ход.


