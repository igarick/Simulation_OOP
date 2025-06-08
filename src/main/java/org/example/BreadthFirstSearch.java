package org.example;

import org.example.entities.*;

import java.util.*;

public class BreadthFirstSearch {

    public static Optional<Coordinates> findFoodTarget(Creature creature, Map map) {
        Queue<Coordinates> queue = new LinkedList<>();
        Set<Coordinates> visited = new HashSet<>();

        int speedCount = creature.getSpeed();
        int step = 0;

        queue.add(creature.coordinates);
        visited.add(creature.coordinates);

        while (!queue.isEmpty() && step < speedCount) {
            int queueSize = queue.size();

            for (int i = 0; i < queueSize; i++) {
                Coordinates current = queue.poll();
                Set<Coordinates> reachableNeighbors = MovementUtils.getReachableNeighbors(current);

                for (Coordinates coordinates : reachableNeighbors) {
                    if (visited.contains(coordinates)) {
                        continue;
                    }
                    visited.add(coordinates);

                    Entity entity = map.getEntity(coordinates);
                    if (creature.canEat(entity)) {
                        return Optional.of(coordinates);
                    } else if (creature.canMoveThrough(entity)) {
                        queue.add(coordinates);
                    }
                }
            }
            step++;
        }
        return Optional.empty();
    }
}

