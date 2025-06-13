package org.example.entities;

import org.example.*;
import org.example.searchPath.Path;

import java.util.List;

public class Herbivore extends Creature {
    public Herbivore(Coordinates coordinates, int speed, int health) {
        super(coordinates, speed, health);
    }

    @Override
    public void makeMove(SimulationMap simulationMap) {
        List<Coordinates> path = Path.findPath(this, simulationMap, this::canEat);

        if (path.size() > 2 && path.size() <= this.getSpeed()) {
            Move move = new Move(this.coordinates, path.get(path.size() - 2));
            simulationMap.makeMove(move);
        } else if (path.size() >= this.getSpeed()) {
            Move move = new Move(this.coordinates, path.get(this.getSpeed()));
            simulationMap.makeMove(move);
        } else if (path.size() == 2) {
            Move move = new Move(this.coordinates, path.get(1));
            simulationMap.makeMove(move);
            increaseHealth();
        }

    }

    protected void increaseHealth() {
        super.increaseHealth(10);
    }


    @Override
    public boolean canMoveThrough(Entity entity) {
        return !(entity instanceof Obstacle || entity instanceof Predator || entity instanceof Herbivore);
    }

    @Override
    public boolean canEat(Entity entity) {
        return entity instanceof Grass;
    }

    @Override
    public boolean isAbilityToMove() {
        return true;
    }


    //Травоядное, наследуется от Creature.
    // Стремятся найти ресурс (траву),
    // может потратить свой ход на движение
    // в сторону травы, либо на её поглощение.
}
