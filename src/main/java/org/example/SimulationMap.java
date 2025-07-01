package org.example;

import org.example.entities.*;

import java.util.*;

public class SimulationMap {
    private static final int ROW_COUNT_DEFAULT = 6;
    private static final int COLUMN_COUNT_DEFAULT = 5;
    private final int rowCount;
    private final int columnCount;

    public int rowCount() {
        return rowCount;
    }

    public int columnCount() {
        return columnCount;
    }

    public SimulationMap() {
        this(ROW_COUNT_DEFAULT, COLUMN_COUNT_DEFAULT);
    }

    public SimulationMap(int rowCount, int columnCount) {
        this.rowCount = rowCount;
        this.columnCount = columnCount;
    }

    private final HashMap<Coordinates, Entity> entities = new HashMap<>();

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

    public List<Entity> getEntityByType(Class<? extends Entity> targetType) {
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
