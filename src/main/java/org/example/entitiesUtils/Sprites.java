package org.example.entitiesUtils;

import org.example.entities.Entity;

public final class Sprites {

    private Sprites() {
    }

    public static String selectSprite(Entity entity) {
        return switch (entity.getClass().getSimpleName()) {
            case "Grass" -> "🍀";
            case "Rock" -> "🏰";
            case "Tree" -> "🌾";
            case "Herbivore" -> "🐇";
            case "Predator" -> "🦊";

                default -> throw new RuntimeException("The sprite wasn't found");
        };
    }

    public static String ground() {
        return "🟫";
    }
}
