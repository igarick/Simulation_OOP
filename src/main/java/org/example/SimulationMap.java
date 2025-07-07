package org.example;

import org.example.entities.*;

import java.util.*;

public class SimulationMap {
    private static final int HEIGHT_DEFAULT = 6;
    private static final int WIDTH_DEFAULT = 5;
    private final int height;
    private final int width;

    private final HashMap<Coordinates, Entity> entities = new HashMap<>();

    public SimulationMap() {
        this(HEIGHT_DEFAULT, WIDTH_DEFAULT);
    }

    public SimulationMap(int height, int width) {
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
        if (coordinates.height < 0 || coordinates.height > height ||
        coordinates.width < 0 || coordinates.width > width) {
            throw new IllegalArgumentException();
        }
        entity.coordinates = coordinates;
        entities.put(coordinates, entity);
    }

    public Entity getEntity(Coordinates coordinates) {
        Entity entity = entities.get(coordinates);
        if (entity == null) {
            throw new NullPointerException();
        }
        return entity;
    }

    public boolean isEmpty(Coordinates coordinates) {
        if (coordinates.height < 0 || coordinates.height > height ||
                coordinates.width < 0 || coordinates.width > width) {
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
        if (coordinates.height < 0 || coordinates.height > height ||
                coordinates.width < 0 || coordinates.width > width) {
            throw new IllegalArgumentException();
        }
        entities.remove(coordinates);
    }

    public void makeMove(Coordinates from, Coordinates to) {

        if (from.height < 0 || from.height > height ||
        from.width < 0 || from.width > width ||
        to.height < 0 || to.height > height ||
        to.width < 0 || to.width > width) {
            throw new IllegalArgumentException();
        }

        Entity entity = entities.get(from);

        removeEntity(from);
        setEntity(to, entity);
    }

}
