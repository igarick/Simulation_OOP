package org.example;

import org.example.entities.Creature;
import org.example.entities.Predator;

import java.util.Queue;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        Map map = new Map();
//        map.setDefaultPositions();
//        Renderer renderer = new Renderer();
//        renderer.renderer(map);
        map.setEntity(new Coordinates(3,3),
                new Predator(new Coordinates(3,3),1,0));

        Renderer renderer = new Renderer();
        renderer.renderer(map);

        //Entity entity = map.getEntity(new Coordinates(0, 0));

        Creature creature = (Creature) map.getEntity(new Coordinates(3,3));

        Queue<Coordinates> coordinates = BreadthFirstSearch.availableSquaresForMove(creature, map);

//        for (Coordinates c : coordinates) {
//            System.out.println("row = " + c.row + ", column = " + c.column);
//        }

        Set<Coordinates> visited = BreadthFirstSearch.getVisited();
        for (Coordinates coordinates1 : visited) {
            System.out.println(coordinates1);
        }
    }
}