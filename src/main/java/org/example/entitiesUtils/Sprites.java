package org.example.entitiesUtils;

import org.example.entities.Entity;

public class Sprites {

    public static String selectSprite(Entity entity) {
        return switch (entity.getClass().getSimpleName()) {
            case "Grass" -> "🌿";
            case "Rock" -> "⛰";
            case "Tree" -> "🌳";
            case "Herbivore" -> "🦌";
            case "Predator" -> "🐅";
            default -> "Unknown entity";
        };
    }
}
