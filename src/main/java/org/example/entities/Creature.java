package org.example.entities;

import org.example.Coordinates;
import org.example.Move;
import org.example.SimulationMap;
import org.example.entitiesUtils.AliveEntity;
import java.util.List;

public abstract class Creature extends Entity implements AliveEntity {
    private final int speed;
    private int health;

    public Creature(Coordinates coordinates, int speed, int health) {
        super(coordinates);
        this.speed = speed;
        this.health = health;
    }

    public void makeMove(SimulationMap simulationMap, List<Coordinates> path) {

        Move move = getMove(simulationMap, path);
        simulationMap.makeMove(move.from, move.to);
    }

    public Move getMove(SimulationMap simulationMap, List<Coordinates> path) {
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

    public int getSpeed() {
        return speed;
    }

    public int getHealth() {
        return health;
    }

    public void adjustHealth(int delta) {
        this.health += delta;
    }

    public void restoreToMaxHealth(int health) {
        this.health = health;
    }

    public void dropToMinHealth(int health) {
        this.health = health;
    }

    public abstract Class<? extends Entity> getTarget();

    public abstract void interactWithTarget(Entity entity);

}



