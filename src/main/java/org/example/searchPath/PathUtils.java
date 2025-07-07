package org.example.searchPath;

import org.example.Coordinates;
import org.example.SimulationMap;

public final class PathUtils {

    private PathUtils() {
    }

    public static boolean canShift(Coordinates coordinates, Coordinates shift, SimulationMap simulationMap) {
        int h = coordinates.height + shift.height;
        int w = coordinates.width + shift.width;

        return ((h >= 0 && h < simulationMap.height()) &&
                (w >= 0 && w < simulationMap.width()));
    }

    public static Coordinates shift(Coordinates coordinates, Coordinates shift) {
        return new Coordinates(coordinates.height + shift.height, coordinates.width + shift.width);
    }

}
