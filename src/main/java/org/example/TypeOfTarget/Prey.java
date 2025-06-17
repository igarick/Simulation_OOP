package org.example.TypeOfTarget;

public interface Prey {
    int getHealth();
    void adjustHealth(int health);

    int getHealthMax();
    int getHealthMin();

    void restoreToMaxHealth(int healthMax);
    void dropToMinHealth(int healthMin);

    boolean isWithinMaxHealth(int healthRestoreAmount);
    boolean isSurvived(int damage);
    boolean isAlive();
}
