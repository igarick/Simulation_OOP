package org.example.entities;

import org.example.*;

public class Herbivore extends Creature {
    private static final int DEFAULT_HEALTH = 100;
    private static final int DEFAULT_SPEED = 3;

    private final int HEALTH_MAX = 100;
    private final int HEALTH_MIN = 0;

    private final Class<? extends Entity> target = Grass.class;

    public Herbivore(Coordinates coordinates) {
        super(coordinates, DEFAULT_SPEED, DEFAULT_HEALTH);
    }

    @Override
    public Class<? extends Entity> getTarget() {
        return target;
    }

    @Override
    public void interactWithTarget(Entity entity) {
        if (entity instanceof Grass grass) {
            eat(grass);
        }
    }

    private void eat(Grass grass) {
        int amountHealth = grass.restoreHealth();

        if (isWithinMaxHealth(amountHealth)) {
            adjustHealth(amountHealth);
        } else {
            restoreToMaxHealth(HEALTH_MAX);
        }
    }

    private boolean isWithinMaxHealth(int amountHealth) {
        return getHealth() + amountHealth <= HEALTH_MAX;
    }

    public void takeDamage(int damage) {
        if (isSurvived(damage)) {
            adjustHealth(- damage);
        } else {
            dropToMinHealth(HEALTH_MIN);
        }
    }

    public boolean isSurvived(int damage) {
        return (getHealth() - damage > HEALTH_MIN);
    }

    @Override
    public boolean isAlive(SimulationMap simulationMap) {
        return getHealth() != HEALTH_MIN;
    }

    }

