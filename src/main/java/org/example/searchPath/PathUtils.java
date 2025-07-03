package org.example.searchPath;

import org.example.Coordinates;
import org.example.SimulationMap;

public class PathUtils {

    public static boolean canShift(Coordinates coordinates, Coordinates shift, SimulationMap simulationMap) {
        int r = coordinates.row + shift.row;
        int c = coordinates.column + shift.column;

        return ((r >= 0 && r < simulationMap.rowCount()) &&
                (c >= 0 && c < simulationMap.columnCount()));
    }

    public static Coordinates shift(Coordinates coordinates, Coordinates shift) {
        return new Coordinates(coordinates.row + shift.row, coordinates.column + shift.column);
    }

}
