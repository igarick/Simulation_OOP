package org.example.entities;

import org.example.*;
//import org.example.TypeOfTarget.Prey;

public class Herbivore extends Creature {
    private final int HEALTH_MAX = 100;
    private final int HEALTH_MIN = 0;

    private final Class<? extends Entity> target = Grass.class;

    private final int HEALTH_RECOVERY = 10;

    public Herbivore(Coordinates coordinates, int speed, int health) {
        super(coordinates, speed, health);
    }

    @Override
    public Class<? extends Entity> getTarget() {
        return target;
    }

    @Override
    public boolean canMoveThrough(Entity entity) {
        return !(entity instanceof Obstacle || entity instanceof Predator || entity instanceof Herbivore);
    }

    @Override
    public boolean isPrey() {
        return true;
    }

//    @Override
//    public boolean isTarget(Entity entity) {
//        return entity instanceof Grass;
//    }

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

//---------------------------Prey------------
//    @Override
//    public boolean isWithinMaxHealth(int healthAmount) {
//        return getHealth() + healthAmount <= HEALTH_MAX;
//    }
//
//    @Override
//    public int getHealthMax() {
//        return HEALTH_MAX;
//    }
//
//    @Override
//    public int getHealthMin() {
//        return HEALTH_MIN;
//    }
//
//
//    @Override
//    public boolean isSurvived(int damage) {
//        return (getHealth() - damage > HEALTH_MIN);
//    }
//
//    @Override
//    public boolean isAlive() {
//        return getHealth() > HEALTH_MIN;
//    }
//
//    @Override
//    public void takeDamage(int damage) {
//        if (isSurvived(damage)) {
//            adjustHealth(damage);
//
//        }
//    }
//---------------------------Prey------------

//    @Override
//    public void setHealth(int healthRestoreAmount) {
//        super.(getHealth() + healthRestoreAmount);
//        super.setHealth(healthRestoreAmount);
    }

    //    public boolean isHealthInBounds() {
//        return !(getHealth() + HEALTH_RECOVERY > HEALTH_MAX);
//    }



    //Травоядное, наследуется от Creature.
    // Стремятся найти ресурс (траву),
    // может потратить свой ход на движение
    // в сторону травы, либо на её поглощение.

