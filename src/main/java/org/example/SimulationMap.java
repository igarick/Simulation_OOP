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

    public int rowCount() {
        return height;
    }

    public int columnCount() {
        return width;
    }

    public void setEntity(Coordinates coordinates, Entity entity) {
        entity.coordinates = coordinates;
        entities.put(coordinates, entity);
    }

    public Entity getEntity(Coordinates coordinates) {
        return entities.get(coordinates);
    }

    public boolean isEmpty(Coordinates coordinates) {
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
        entities.remove(coordinates);
    }

    public void makeMove(Coordinates from, Coordinates to) {
        Entity entity = entities.get(from);

        removeEntity(from);
        setEntity(to, entity);
    }

}
