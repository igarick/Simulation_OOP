package org.example.searchPath;

import org.example.Coordinates;
import org.example.SimulationMap;
import org.example.entities.Creature;
import org.example.entities.Entity;

import java.util.*;

public class PathFinder {

    public static List<Coordinates> findPath(Creature creature, SimulationMap simulationMap, Class<? extends Entity> target) {
        Queue<Coordinates> queue = new LinkedList<>();
        Set<Coordinates> visited = new HashSet<>();
        List<Coordinates> path = new LinkedList<>();
        Map<Coordinates, Coordinates> cameFrom = new HashMap<>();

        queue.add(creature.coordinates);
        visited.add(creature.coordinates);
        cameFrom.put(creature.coordinates, null);

        while (!queue.isEmpty()) {
            Coordinates current = queue.poll();
            Set<Coordinates> neighbors = getReachableNeighbors(current, simulationMap, target);

            for (Coordinates coordinates : neighbors) {
                if (visited.contains(coordinates)) {
                    continue;
                }

                visited.add(coordinates);
                cameFrom.put(coordinates, current);

                if (!simulationMap.isEmpty(coordinates) && target.isInstance(simulationMap.getEntity(coordinates))) {
                    return constructPathToTarget(cameFrom, coordinates);
                }
                queue.add(coordinates);
            }
        }
        return path;
    }

    private static Set<Coordinates> getReachableNeighbors(Coordinates coordinates, SimulationMap simulationMap, Class<? extends Entity> target) { //, Creature creature
        Set<Coordinates> result = new HashSet<>();

        for (Direction direction : Direction.values()) {
            Coordinates shift = direction.getCoordinates();
            if (PathUtils.canShift(coordinates, shift, simulationMap)) {
                Coordinates neighbor = PathUtils.shift(coordinates, shift);
                if ((simulationMap.isEmpty(neighbor)) || target.isInstance(simulationMap.getEntity(neighbor))) {
                    result.add(neighbor);
                }
            }
        }
        return result;
    }

    private static List<Coordinates> constructPathToTarget(Map<Coordinates, Coordinates> cameFrom, Coordinates coordinates) {
        List<Coordinates> result = new LinkedList<>();
        Coordinates current = coordinates;
        while (current != null) {
            result.addFirst(current);
            current = cameFrom.get(current);
        }
        result.removeFirst();

        return result;
    }

}

