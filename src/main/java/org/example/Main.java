package org.example;

import org.example.entities.*;

import java.util.Optional;

public class Main {

    public static void main(String[] args) {

        Map map = new Map();

        map.setEntity(new Coordinates(0,0),
                new Predator(new Coordinates(0,0),2,0));

        map.setEntity(new Coordinates(0,1),
                new Herbivore(new Coordinates(0,1),2,0));
//
        map.setEntity(new Coordinates(2,1),
                new Grass(new Coordinates(2,1)));

//        map.setEntity(new Coordinates(1,0),
//                new Rock(new Coordinates(1,0)));

        Renderer renderer = new Renderer();
        renderer.renderer(map);

        Creature creature = (Creature) map.getEntity(new Coordinates(0,1));

        Optional<Coordinates> coordinates = FirstStepToFood.findStep(creature, map);
//        if (coordinates.isEmpty()) {
//
//        }
        System.out.println(coordinates);

//        Queue<Coordinates> coordinates = BreadthFirstSearch.availableSquaresForMove(creature, map);
//        for (Coordinates c : coordinates) {
//            System.out.println("row = " + c.row + ", column = " + c.column);
//        }

        System.out.println("------------------------------------------");

    }
}