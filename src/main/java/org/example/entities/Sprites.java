package org.example.entities;

public class Sprites {

    public static String selectSprite(Entity entity) {
        switch (entity.getClass().getSimpleName()) {
            case "Grass" :
                return "\uD83C\uDF3F";
            case "Rock" :
                return "⛰";
            case "Tree" :
                return "\uD83C\uDF33";
            case "Herbivore" :
                return "\uD83E\uDD8C";
            case "Predator" :
                return "\uD83D\uDC05";

            default:
                return "Unknown entity";
        }
    }
}
