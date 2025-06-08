package org.example;

import org.example.entities.CoordinatesShift;

import java.util.HashSet;
import java.util.Set;

public class MovementUtils {
    public static Set<Coordinates> getReachableNeighbors(Coordinates coordinates) {
        Set<Coordinates> result = new HashSet<>();

        for (CoordinatesShift shift : CoordinatesShift.shifts()) {
            if (coordinates.canShift(shift)) {
                Coordinates newCoordinates = coordinates.shift(shift);
                    result.add(newCoordinates);
            }
        }
        return result;
    }
}
