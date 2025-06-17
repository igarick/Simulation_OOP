package org.example;


import org.example.entities.Creature;
import org.example.entities.Entity;

//public class InteractionWithTarget {
//
//    public static void interactWithTargetNNNNN(Creature creature, Entity target) {
//
//        if(creature instanceof Prey && target instanceof Food) {
//            Prey prey =  (Prey) creature;
//            Food food = (Food) target;
//
//            int healthAmount = food.getHealthRestoreAmount();
//
//            if (prey.isWithinMaxHealth(healthAmount)) {
//                prey.adjustHealth(healthAmount);
//            } else {
//                prey.restoreToMaxHealth(prey.getHealthMax());
//            }
//        } else if (creature instanceof Hunter && target instanceof Prey) {
//            Hunter hunter = (Hunter) creature;
//            Prey prey = (Prey) target;
//
//            int damage = hunter.getDamage();
////            int preyHealth = prey.getHealth();
//
//            if (prey.isSurvived(damage)) {
//                prey.adjustHealth(-damage);
//            } else {
//                prey.dropToMinHealth(prey.getHealthMin());
//            }
//        }
////
////        if (isHealthInBounds()) {
////            setHealth(getHealth() + HEALTH_RECOVERY);
////        } else {
////            setHealth(HEALTH_MAX);
////        }
//    }
//}
