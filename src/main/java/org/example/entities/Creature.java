package org.example.entities;

import org.example.Coordinates;
import org.example.Move;
import org.example.SimulationMap;
import org.example.entitiesUtils.AliveEntity;
import org.example.searchPath.PathFinder;

import java.util.List;

public abstract class Creature extends Entity implements AliveEntity {
    private final int speed;
    private int health;
    private Coordinates coordinates;

    public Creature(Coordinates coordinates, int speed, int health) {
        this.speed = speed;
        this.health = health;
        this.coordinates = coordinates;
    }

    public void makeMove(SimulationMap simulationMap) {
        List<Coordinates> path = PathFinder.findPath(simulationMap, this.coordinates, getTarget());

        Move move = getMove(simulationMap, path);
        simulationMap.makeMove(move.from, move.to);
        this.coordinates = move.to;
    }

    private Move getMove(SimulationMap simulationMap, List<Coordinates> path) {
        int pathSize = path.size();

        if (pathSize == 0) {
            return new Move(this.coordinates, this.coordinates);
        }

        if (pathSize == 1) {
            Entity entity = simulationMap.getEntity(path.getFirst());
            if (shouldOccupyTargetPosition(entity, simulationMap)) {
                return new Move(this.coordinates, path.getFirst());
            } else {
                return new Move(this.coordinates, this.coordinates);
            }
        }

        if (pathSize <= this.speed) {
            // встать перед целью
            return new Move(this.coordinates, path.get(pathSize - 2));
        }

        return new Move(this.coordinates, path.get(this.getSpeed() - 1));
    }

    private boolean shouldOccupyTargetPosition(Entity entity, SimulationMap simulationMap) {
        interactWithTarget(entity);
        if (entity instanceof AliveEntity aliveEntity) {
            if (aliveEntity.isAlive(simulationMap)) {
                return false;
            }
        }
        return true;
    }

//    private boolean shouldOccupyTargetPosition(Entity entity, SimulationMap simulationMap) {
//        interactWithTarget(entity);
//        if (entity instanceof AliveEntity aliveEntity) {
//            if (aliveEntity.isAlive(simulationMap)) {
//                return false;
//            }
//        }
//        return true;
//    }

    private int getSpeed() {
        return speed;
    }

    protected int getHealth() {
        return health;
    }

    protected void adjustHealth(int delta) {
        this.health += delta;
    }

    protected void restoreToMaxHealth(int health) {
        this.health = health;
    }

    protected void dropToMinHealth(int health) {
        this.health = health;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public abstract Class<? extends Entity> getTarget();

    protected abstract void interactWithTarget(Entity entity);

}



