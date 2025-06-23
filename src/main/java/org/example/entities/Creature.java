package org.example.entities;

import org.example.Coordinates;
import org.example.Move;
import org.example.SimulationMap;
import org.example.dao.AliveEntity;
import org.example.searchPath.Path;


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
        Move move = getCoordinatesForMove(simulationMap, path);
        simulationMap.makeMove(move.from, move.to);
    }

    public Move getCoordinatesForMove(SimulationMap simulationMap, List<Coordinates> path) {
//        List<Coordinates> path = Path.findPath(this, simulationMap, this::isTarget);
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

//    public abstract boolean isTarget(Entity entity);

    public abstract Class<? extends Entity> getTarget();

    public abstract void interactWithTarget(Entity entity);

    public abstract boolean canMoveThrough(Entity entity);

    public abstract boolean isPrey();

//    abstract boolean isHealthInBounds(int healthAmount);


//    protected void increaseHealth(int health) {
//        if (isHealthInBounds(health)) {
//            this.health += health;
//        } else {
//            this.health = 100;
//        }
//    }
//
//    protected boolean isHealthInBounds(int health) {
//        return !(this.health + health > 100);
//    }
}


//Абстрактный класс, наследуется от Entity.
// Существо, имеет скорость (сколько клеток может пройти
// за 1 ход), количество HP. Имеет метод makeMove() -
// сделать ход.


