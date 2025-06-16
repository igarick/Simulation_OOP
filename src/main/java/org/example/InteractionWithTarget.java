package org.example;

import org.example.TypeOfTarget.Food;
import org.example.TypeOfTarget.Prey;
import org.example.entities.Creature;
import org.example.entities.Entity;

public class InteractionWithTarget {

    public void interactWithTargetNNNNN(Creature creature, Entity target) {

        if(creature instanceof Prey && target instanceof Food) {
            Prey prey =  (Prey) creature;
            Food food = (Food) target;

            int healthAmount = food.getHealthRestoreAmount();

            if (prey.isHealthInBounds(healthAmount)) {
                prey.setHealth(healthAmount);
            } else {
                prey.setHealthMax(prey.getHealthMax());
            }


        }
//
//        if (isHealthInBounds()) {
//            setHealth(getHealth() + HEALTH_RECOVERY);
//        } else {
//            setHealth(HEALTH_MAX);
//        }
    }
}
