package org.example;

import org.example.entities.CoordinatesShift;
import org.example.entities.Creature;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BreadthFirstSearch {
//    Creature creature;
//
//    public BreadthFirstSearch(Creature creature) {
//        this.creature = creature;
//    }

    private static final Set<Coordinates> visited = new HashSet<>();

    private static final Queue<Coordinates> queue = new LinkedList<>();

    private static Set<CoordinatesShift> shifts() {
        Set<CoordinatesShift> result = new HashSet<>();

        result.add(new CoordinatesShift(1, 0));
        result.add(new CoordinatesShift(0, 1));
        result.add(new CoordinatesShift(-1, 0));
        result.add(new CoordinatesShift(0, -1));

        return result;
    }
    public static Queue<Coordinates> availableSquaresForMove(Creature creature, Map map) {
        int speedCount = creature.getSpeed();
        int step = 0;

        queue.clear();
        visited.clear();

        queue.add(creature.coordinates);
        visited.add(creature.coordinates);

        while (!queue.isEmpty() && step <= speedCount) {
            int queueSize = queue.size();

            for (int i = 0; i < queueSize; i++) {
                Coordinates removedCoordinate = queue.remove();

                Set<Coordinates> nextCoordinates = getNextCoordinates(removedCoordinate, map);
                for (Coordinates coordinate : nextCoordinates) {
                    visited.add(coordinate);
                    queue.add(coordinate);
                }
            }

//            queue.addAll(getNextCoordinates(removedCoordinate, map));

            step++;
        }
        return queue;
    }

    private static Set<Coordinates> getNextCoordinates(Coordinates coordinate, Map map) {
        Set<Coordinates> result = new HashSet<>();

        for (CoordinatesShift shift : shifts()) {
            if (coordinate.canShift(shift)) {
                Coordinates newCoordinate = coordinate.shift(shift);

                if(isCoordinateAvailable(newCoordinate,map)) {
                    result.add(newCoordinate);
                }
            }
        }

        return result;
    }

    protected static boolean isCoordinateAvailable(Coordinates coordinate, Map map) {
        return ((map.isEmpty(coordinate)) && !visited.contains(coordinate));
    }

    public static Set<Coordinates> getVisited() {
        return visited;
    }


//
//    public Set<Coordinates> getVertexes(Coordinates coordinates) {
//        Set<Coordinates> vertexes = new HashSet<>();
//
//
//
//        return vertexes;

//    }

//
//    public static Set<Coordinates> getVertexes(Creature creature, Map map) {
//        Set<Coordinates> allAvailableVertexes = new HashSet<>();
//
//        for (CoordinatesShift shift : defaultShifts()) {
//            if (creature.coordinates.canShift(shift)) {
//                Coordinates newCoordinates = creature.coordinates.shift(shift);
//
//                if(isVertexAvailable(newCoordinates, map)) {
//                    allAvailableVertexes.add(newCoordinates);
//
//                }
//            }
//        }
//        return allAvailableVertexes;

//    }

}

//
//нач коор 0,0
//поиск вершин: 0,0 + {-1,0 / 1,0 / 0,1 / 0,-1}
//полученные вершины -> в Очередь
//проверка полученных вершин по очереди на доступность -> проверка на условия -> если нет
//то эту координату в "посещенные"
//        -> для проверенной вершины определить смежные вершины 1,0 + {-1,0 / 1,0 / 0,1 / 0,-1}
//        -> полученные вершины проверить в "посещенных"
//        -> добавить в Очередь

