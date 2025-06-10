package org.example;

import org.example.entities.*;

import java.util.Optional;

public class Main {

    public static void main(String[] args) {

        Map map = new Map();

//        map.setEntity(new Coordinates(0,0),
//                new Predator(new Coordinates(0,0),2,0));

        map.setEntity(new Coordinates(0, 0),
                new Herbivore(new Coordinates(0, 0), 2, 90));
//
        map.setEntity(new Coordinates(0, 3),
                new Grass(new Coordinates(0, 3)));

        map.setEntity(new Coordinates(5, 5),
                new Grass(new Coordinates(5, 5)));

//        map.setEntity(new Coordinates(1,0),
//                new Rock(new Coordinates(1,0)));

        Renderer renderer = new Renderer();
        renderer.renderer(map);

        System.out.println("------------------------------------------");

        Creature creature = (Creature) map.getEntity(new Coordinates(0, 0));
        creature.makeMove(map);

        renderer.renderer(map);
        int health = creature.getHealth();
        System.out.println(health);
        System.out.println("------------------------------------------");



    }

    }
