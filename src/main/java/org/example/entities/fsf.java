package org.example.entities;

import org.example.Coordinates;
import org.example.Map;
import org.example.MovementUtils;

import java.util.*;
import java.util.function.Predicate;

public class fsf {

    public static List<Coordinates> findStep(Creature creature, Map map, Predicate<Entity> condition) {
        Queue<Coordinates> queue = new LinkedList<>();
        Set<Coordinates> visited = new HashSet<>();
        List<Coordinates> path = new LinkedList<>();
        java.util.Map<Coordinates, Coordinates> cameFrom = new HashMap<>();

        Coordinates target = null;

        queue.add(creature.coordinates);
        visited.add(creature.coordinates);
        cameFrom.put(creature.coordinates, null);

        while (!queue.isEmpty()) {

            Coordinates current = queue.poll();
            Set<Coordinates> reachableNeighbors = MovementUtils.getReachableNeighbors(current);

            for (Coordinates coordinates : reachableNeighbors) {
                if (visited.contains(coordinates)) {
                    continue;
                }
                visited.add(coordinates);
                cameFrom.put(coordinates, current);

                Entity entity = map.getEntity(coordinates);
                if (condition.test(entity)) {
                    target = coordinates;
                    break;
                } else if (creature.canMoveThrough(entity)) {
                    queue.add(coordinates);
                }
            }
            if (target != null) {
                break;
            }
        }
        if (target != null) {
            Coordinates current = target;
            while (current != null) {
                path.add(0, current); // вставка в начало
                current = cameFrom.get(current);
            }
        }
            return path;
    }
}

