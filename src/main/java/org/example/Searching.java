package org.example;

import org.example.entities.Creature;
import org.example.entities.Entity;

import java.util.*;
import java.util.function.Predicate;

public class Searching {

    public static java.util.Map<Coordinates, Coordinates> getAvailableSquares(Creature creature, Map map) {
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

                    Entity entity = map.getEntity(coordinates);
                    if (creature.canMoveThrough(entity)) {
                        queue.add(coordinates);
                        cameFrom.put(coordinates, current);
                        visited.add(coordinates);
                    }
                }
            }
            step++;
        }
        return (visited, cameFrom);

//                    Entity entity = map.getEntity(coordinates);
//                    if (condition.test(entity)) {
//                        Coordinates previous = cameFrom.get(coordinates);
//                        return Optional.of(previous);
//
//                    } else if (creature.canMoveThrough(entity)) {
//                        queue.add(coordinates);
    }
}

