package org.example;

import org.example.entities.CoordinatesShift;
import org.example.entities.Creature;

import java.util.HashSet;
import java.util.Set;

public class BreadthFirstSearch {

//    private Set<CoordinatesShift> stepOfMove() {
//        Set<CoordinatesShift> result = new HashSet<>();
//
//        result.add(new CoordinatesShift(0, 1));
//        result.add(new CoordinatesShift(0, -1));
//        result.add(new CoordinatesShift(1, 0));
//        result.add(new CoordinatesShift(-1, 0));
//
//        return result;
//    }
//
//    public Set<Coordinates> vertexes(Creature creature) {
//        Set<Coordinates> allAvailableVertexes = new HashSet<>();
//
//        for (CoordinatesShift shift : stepOfMove()) {
//            if (Coordinates.canShift(shift)) {
//
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