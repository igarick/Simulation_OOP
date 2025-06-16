package org.example.TypeOfTarget;

public interface Prey {
    boolean isHealthInBounds(int healthRestoreAmount);
//    int getHealth();
    void setHealth(int healthRestoreAmount);
    int getHealthMax();
    void setHealthMax(int healthMax);
}
