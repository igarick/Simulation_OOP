package org.example.entities;

import org.example.Coordinates;
import org.example.SimulationMap;

public class Predator extends Creature {
    private static final int DEFAULT_HEALTH = 100;
    private static final int DEFAULT_SPEED = 1;
    private final int damage = 20;
    private final Class<? extends Entity> target = Herbivore.class;

    public Predator(Coordinates coordinates) {
        super(coordinates, DEFAULT_SPEED, DEFAULT_HEALTH);
    }

    @Override
    public Class<? extends Entity> getTarget() {
        return target;
    }

    @Override
    public void interactWithTarget(Entity entity) {
        if (entity instanceof Herbivore herbivore) {
            attack(herbivore);
        }
    }

    private void attack(Herbivore herbivore) {
        herbivore.takeDamage(damage);
    }

    @Override
    public boolean isAlive(SimulationMap simulationMap) {
        return true;
    }
}
