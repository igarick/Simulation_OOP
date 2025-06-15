package org.example.entities;

import org.example.*;
import org.example.strategyInteraction.InteractionStrategy;

import java.util.List;

public class Herbivore extends Creature {
    private final int HEALTH_MAX = 100;
    private final int HEALTH_RECOVERY = 10;

    public Herbivore(Coordinates coordinates, int speed, int health) {
        super(coordinates, speed, health);
    }

//    @Override
//    public void makeMove(SimulationMap simulationMap, List<Coordinates> path) {
//        List<Coordinates> path = Path.findPath(this, simulationMap, this::isTarget);
//
//        if (path.size() > 2 && path.size() <= this.getSpeed()) {
//            simulationMap.makeMove(this.coordinates, path.get(path.size() - 2));
//        } else if (path.size() >= this.getSpeed()) {
//            simulationMap.makeMove(this.coordinates, path.get(this.getSpeed()));
//        } else if (path.size() == 2) {
//            simulationMap.makeMove(this.coordinates, path.get(1));
//        }
//    }

    @Override
    public boolean canMoveThrough(Entity entity) {
        return !(entity instanceof Obstacle || entity instanceof Predator || entity instanceof Herbivore);
    }

    @Override
    public boolean isTarget(Entity entity) {
        return entity instanceof Grass;
    }

    @Override
    public boolean isAbilityToMove() {
        return true;
    }

    @Override
    public void interactWithTarget() {
        if (isHealthInBounds()) {
            setHealth(getHealth() + HEALTH_RECOVERY);
        } else {
            setHealth(HEALTH_MAX);
        }
    }

    private boolean isHealthInBounds() {
        return !(getHealth() + HEALTH_RECOVERY > HEALTH_MAX);
    }



    //Травоядное, наследуется от Creature.
    // Стремятся найти ресурс (траву),
    // может потратить свой ход на движение
    // в сторону травы, либо на её поглощение.
}
