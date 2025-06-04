package org.example;

import org.example.entities.Creature;
import org.example.entities.Predator;

import java.util.Set;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello, World!");
        Map map = new Map();
//        map.setDefaultPositions();

//        Renderer renderer = new Renderer();
//        renderer.renderer(map);
        map.setEntity(new Coordinates(3,3),
                new Predator(new Coordinates(3,3),0,0));

        Renderer renderer = new Renderer();
        renderer.renderer(map);

        //Entity entity = map.getEntity(new Coordinates(0, 0));

        Creature creature = (Creature) map.getEntity(new Coordinates(3,3));

        Set<Coordinates> availableMoves = creature.getVertexes(map);

        for (Coordinates c : availableMoves) {
            System.out.println("row = " + c.row + ", column = " + c.column);
        }

    }
}