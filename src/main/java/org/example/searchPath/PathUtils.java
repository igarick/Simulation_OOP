package org.example.searchPath;

import org.example.Coordinates;
import org.example.SimulationMap;

public class PathUtils {

    public static boolean canShift(Coordinates coordinates, Coordinates shift, SimulationMap simulationMap) {
        int r = coordinates.height + shift.height;
        int c = coordinates.width + shift.width;

        return ((r >= 0 && r < simulationMap.height()) &&
                (c >= 0 && c < simulationMap.width()));
    }

    public static Coordinates shift(Coordinates coordinates, Coordinates shift) {
        return new Coordinates(coordinates.height + shift.height, coordinates.width + shift.width);
    }

}
