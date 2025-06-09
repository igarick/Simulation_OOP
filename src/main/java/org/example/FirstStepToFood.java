package org.example;

import org.example.entities.*;

import java.util.*;

public class FirstStepToFood {

    public static Optional<Coordinates> findStep(Creature creature, Map map) {
        Queue<Coordinates> queue = new LinkedList<>();
        Set<Coordinates> visited = new HashSet<>();
        HashMap<Coordinates, Coordinates> cameFrom = new HashMap<>();


        int speedCount = creature.getSpeed();
        int step = 0;

        queue.add(creature.coordinates);
        visited.add(creature.coordinates);
        cameFrom.put(creature.coordinates, null);

        while (!queue.isEmpty() && step < speedCount) {
            int queueSize = queue.size();

            for (int i = 0; i < queueSize; i++) {
                Coordinates current = queue.poll();
                Set<Coordinates> reachableNeighbors = MovementUtils.getReachableNeighbors(current);

                for (Coordinates coordinates : reachableNeighbors) {
                    if (visited.contains(coordinates)) {
                        continue;
                    }
                    cameFrom.put(coordinates, current);
                    visited.add(coordinates);

                    Entity entity = map.getEntity(coordinates);
                    if (creature.canEat(entity)) {
                        Coordinates previous = cameFrom.get(coordinates);
                        return Optional.of(previous);

//                        return Optional.of(coordinates);
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

