package org.example;

import org.example.entities.*;

import java.util.*;

public class SimulationMap {

    private static final int ROW_COUNT_DEFAULT = 6;
    private static final int COLUMN_COUNT_DEFAULT = 5;
    private final int rowCount;
    private final int columnCount;

    public SimulationMap() {
        this(ROW_COUNT_DEFAULT, COLUMN_COUNT_DEFAULT);
    }

    public SimulationMap(int rowCount, int columnCount) {
        this.rowCount = rowCount;
        this.columnCount = columnCount;
    }

    //Карта, содержит в себе коллекцию для хранения
    // существ и их расположения


//    private final Random random = new Random(); // для рандомных координат
//    private final Set<Coordinates> defaultPositions = new HashSet<>(); // для рандомных координат

    private final HashMap<Coordinates, Entity> entities = new HashMap<>();

    public void setEntity(Coordinates coordinates, Entity entity) {
        entity.coordinates = coordinates;
        entities.put(coordinates, entity);
    }

    public void setDefaultPositions() {
        setEntity(new Coordinates(1, 1), new Grass(new Coordinates(1, 1)));
        setEntity(new Coordinates(2, 2), new Rock(new Coordinates(2, 2)));
        setEntity(new Coordinates(3, 3), new Tree(new Coordinates(3, 3)));
        setEntity(new Coordinates(4, 4), new Herbivore(new Coordinates(4, 4), 2, 100, 0));
        setEntity(new Coordinates(0, 0), new Predator(new Coordinates(0, 0), 1, 100, 50));
    }

    public Entity getEntity(Coordinates coordinates) {
        return entities.get(coordinates);
    }

    public boolean isEmpty(Coordinates coordinates) {
        return !entities.containsKey(coordinates);
    }

    public List<Creature> getEntitiesForMove() {
        List<Creature> result = new ArrayList<>();

        for (Entity entity : entities.values()) {
            if (entity instanceof Creature creature && entity.isAbilityToMove()) {
                result.add(creature);
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

//    public void makeMove(Move move) {
//        Entity entity = entities.get(move.from);
//
//        removeEntity(move.from);
//        setEntity(move.to, entity);
//
//
//    }

    public int rowCount() {
        return rowCount;
    }

    public int columnCount() {
        return columnCount;
    }

//----------!!!!!!!!!!!!!!!!!!!!!!!-------- random coordinates--------!!!!!!!!!!!!!!!!!--------------- // для рандомных координат
//    public void setDefaultPositions() {
//        Coordinates gCoor = getRandomCoor();
//        setEnt(new Grass(gCoor));
//
//        Coordinates rCoor = getRandomCoor();
//        setEnt(new Rock(rCoor));
//
//        Coordinates pCoor = getRandomCoor();
//        setEnt(new Predator(pCoor, 10, 10));
//    }
//
//    public void setEntity(Entity entity) {
//        Coordinates coordinates = entity.coordinates;
//        entities.put(coordinates, entity);
//
//    }
//
//    public Coordinates getRandomCoordinates() {
//        Coordinates coordinates;
//
//        do {
//            coordinates = new Coordinates(random.nextInt(10), random.nextInt(4));
//        } while (!defaultPositions.add(coordinates));
//
//        return coordinates;
//    }
    //------------------ random coordinates-----------------------

}
