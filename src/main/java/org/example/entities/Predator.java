package org.example.entities;

import org.example.Coordinates;
import org.example.SimulationMap;

public class Predator extends Creature {
    private final int damage = 10;
    private final Class<? extends Entity> target = Herbivore.class;

    public Predator(Coordinates coordinates, int speed, int health) {
        super(coordinates, speed, health);
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
