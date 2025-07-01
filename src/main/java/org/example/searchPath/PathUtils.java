package org.example.searchPath;

import org.example.Coordinates;
import org.example.SimulationMap;
import org.example.entitiesUtils.CoordinatesShift;

public class PathUtils {

    public static boolean canShift(Coordinates coordinates, CoordinatesShift shift, SimulationMap simulationMap) {
        int r = coordinates.row + shift.rowShift;
        int c = coordinates.column + shift.columnShift;

        return ((r >= 0 && r < simulationMap.rowCount()) &&
                (c >= 0 && c < simulationMap.columnCount()));
    }

    public static Coordinates shift(Coordinates coordinates, CoordinatesShift shift) {
        return new Coordinates(coordinates.row + shift.rowShift, coordinates.column + shift.columnShift);
    }

}
