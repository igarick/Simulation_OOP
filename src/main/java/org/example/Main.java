package org.example;

import org.example.entities.Entity;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        Map map = new Map();
        map.setDefaultPositions();

        Renderer renderer = new Renderer();
        renderer.renderer(map);
    }
}