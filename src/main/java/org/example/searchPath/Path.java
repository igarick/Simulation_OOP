package org.example.searchPath;

import org.example.Coordinates;
import org.example.SimulationMap;
import org.example.entities.CoordinatesShift;
import org.example.entities.Creature;
import org.example.entities.Entity;

import java.util.*;

public class Path {

    public static List<Coordinates> findPath(Creature creature, SimulationMap simulationMap, Class<? extends Entity> target) {   //Predicate<Entity> condition
        Queue<Coordinates> queue = new LinkedList<>();
        Set<Coordinates> visited = new HashSet<>();
        List<Coordinates> path = new LinkedList<>();
        Map<Coordinates, Coordinates> cameFrom = new HashMap<>();

        queue.add(creature.coordinates);
        visited.add(creature.coordinates);
        cameFrom.put(creature.coordinates, null);

        while (!queue.isEmpty()) {
            Coordinates current = queue.poll();
            Set<Coordinates> neighbors = getReachableNeighbors(current, simulationMap, creature);

            for (Coordinates coordinates : neighbors) {
                if (visited.contains(coordinates)) {
                    continue;
                }

                visited.add(coordinates);
                cameFrom.put(coordinates, current);

                Entity entity = simulationMap.getEntity(coordinates);

                if (target.isInstance(entity)) {
//                if (condition.test(entity)) {
                    return constructPathToTarget(cameFrom, coordinates);
                } else {
                    queue.add(coordinates);
                }
            }
        }
        return path;
    }

    private static Set<Coordinates> getReachableNeighbors(Coordinates coordinates, SimulationMap simulationMap, Creature creature) {
        Set<Coordinates> result = new HashSet<>();

        for (Direction direction : Direction.values()) {
            CoordinatesShift shift = direction.shift();
            if (PathUtils.canShift(coordinates, shift, simulationMap)) {
                Coordinates neighbor = PathUtils.shift(coordinates, shift);
                Entity entity = simulationMap.getEntity(neighbor);
                if (creature.canMoveThrough(entity)) {
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


    //--------------------------------------------------------------------------------------------------------------------------------

//    public static List<Coordinates> findPath(Creature creature, SimulationMap simulationMap, Class<? extends Entity> targetType ) {   //Predicate<Entity> condition
//        Queue<Coordinates> queue = new LinkedList<>();
//        Set<Coordinates> visited = new HashSet<>();
//        List<Coordinates> path = new LinkedList<>();
//        Map<Coordinates, Coordinates> cameFrom = new HashMap<>();
//
////        Coordinates targetCoordinates = null;
//
//        queue.add(creature.coordinates);
//        visited.add(creature.coordinates);
//        cameFrom.put(creature.coordinates, null);
//
//        while (!queue.isEmpty()) {
//            Coordinates current = queue.poll();
//            Set<Coordinates> neighbors = getReachableNeighbors(current, simulationMap, creature);
//
//            for (Coordinates coordinates : neighbors) {
//                if (visited.contains(coordinates)) {
//                    continue;
//                }
//
//                Entity entity = simulationMap.getEntity(coordinates);
//
//                if (targetType.isInstance(entity)) {
////                    targetCoordinates = coordinates;
//                    return constructPathToTargetType(cameFrom, coordinates);
////                    break;
//                }
//
//                if (entity != null && !entity.isPassable()) {
//                    continue;
//                }
//
//                if (entity == null) {
//                    visited.add(coordinates);
//                    cameFrom.put(coordinates, current);
//                    queue.add(coordinates);
//                }
//
////                    visited.add(coordinates);
////                    cameFrom.put(coordinates, current);
////                    queue.add(coordinates);
//
//            }
////            if (targetCoordinates != null) {
////                break;
////            }
//        }
////        if (targetCoordinates != null) {
////            Coordinates current = targetCoordinates;
////            while (current != null) {
////                path.addFirst(current); // вставка в начало
////                current = cameFrom.get(current);
////            }
////            path.removeFirst();
////        }
//        return path;
//    }
//
//    private static List<Coordinates> constructPathToTargetType(Map<Coordinates, Coordinates> cameFrom, Coordinates coordinates) {
//        List<Coordinates> result = new LinkedList<>();
//        Coordinates current = coordinates;
//        while (current != null) {
//            result.addFirst(current);
//            current = cameFrom.get(current);
//        }
//
//        result.removeFirst();
//
//        return result;
//    }
//
//    private static Set<Coordinates> getReachableNeighbors(Coordinates coordinates, SimulationMap simulationMap, Creature creature) {
//        Set<Coordinates> result = new HashSet<>();
//
//        for (Direction direction : Direction.values()) {
//            CoordinatesShift shift = direction.shift();
//            if (PathUtils.canShift(coordinates, shift, simulationMap)) {
//                Coordinates neighbor = PathUtils.shift(coordinates, shift);
////                Entity entity = simulationMap.getEntity(neighbor);
////                if (creature.canMoveThrough(entity)) {
//                    result.add(neighbor);
////                }
//            }
//        }
//        return result;
//    }
    //--------------------------------------------------------------------------------------------------------------------------------


}

