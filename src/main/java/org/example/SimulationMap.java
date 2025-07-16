package org.example;

import org.example.entities.*;

import java.util.*;

public class SimulationMap {
    private static final int DEFAULT_MIN_HEIGHT = 5;
    private static final int DEFAULT_MAX_HEIGHT = 30;
    private static final int DEFAULT_MIN_WIDTH = 5;
    private static final int DEFAULT_MAX_WIDTH = 30;
    private final int height;
    private final int width;

    private final int MIN_SIDE = 4;

    private final HashMap<Coordinates, Entity> entities = new HashMap<>();

    public SimulationMap() {
        this(DEFAULT_MIN_HEIGHT, DEFAULT_MIN_WIDTH);
    }

    public SimulationMap(int height, int width) {
        if (!isMapInBounds(height, width)) {
            throw new IllegalArgumentException(
                    String.format("The height must be between %d and %d and the width between %d and %d",
                            DEFAULT_MIN_HEIGHT, DEFAULT_MAX_HEIGHT, DEFAULT_MIN_WIDTH, DEFAULT_MAX_WIDTH));
        }
        this.height = height;
        this.width = width;
    }

    public int height() {
        return height;
    }

    public int width() {
        return width;
    }

    public void setEntity(Coordinates coordinates, Entity entity) {
        if (!isWithinBounds(coordinates)) {
            throw new IllegalArgumentException();
        }
        entities.put(coordinates, entity);
    }

    public Entity getEntity(Coordinates coordinates) {
        Entity entity = entities.get(coordinates);
        if (entity == null) {
                System.err.println("Ошибка: пустая клетка на " + coordinates);
            throw new NullPointerException();
        }
        return entity;
    }

    public boolean isEmpty(Coordinates coordinates) {
        if (!isWithinBounds(coordinates)) {
            throw new IllegalArgumentException();
        }
        return !entities.containsKey(coordinates);
    }

    public List<Entity> getEntities() {
        return new ArrayList<>(entities.values());
    }

    public List<Entity> getEntitiesByType(Class<? extends Entity> targetType) {
        List<Entity> result = new ArrayList<>();

        for (Entity entity : entities.values()) {
            if (targetType.equals(entity.getClass())) {
                result.add(entity);
            }
        }
        return result;
    }

    public void removeEntity(Coordinates coordinates) {
        if (!isWithinBounds(coordinates)) {
            throw new IllegalArgumentException();
        }
        entities.remove(coordinates);
    }

    public void makeMove(Coordinates from, Coordinates to) {
        if ((!isWithinBounds(from) || !isWithinBounds(to))) {
            throw new IllegalArgumentException();
        }

        Entity entity = entities.get(from);

        removeEntity(from);
        setEntity(to, entity);
    }

    private boolean isWithinBounds(Coordinates coordinates) {
        return (coordinates.height >= 0 && coordinates.height < height &&
                coordinates.width >= 0 && coordinates.width < width);
    }

    private boolean isMapInBounds(int height, int width) {
        return (height >= DEFAULT_MIN_HEIGHT && height <= DEFAULT_MAX_HEIGHT &&
                width >= DEFAULT_MIN_WIDTH && width <= DEFAULT_MAX_WIDTH);
    }

}
