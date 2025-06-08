package org.example.entities;

import java.util.HashSet;
import java.util.Set;

public class CoordinatesShift {
    public final int rowShift;
    public final int columnShift;


    public CoordinatesShift(int rowShift, int columnShift) {
        this.rowShift = rowShift;
        this.columnShift = columnShift;
    }

    public static Set<CoordinatesShift> shifts() {
        Set<CoordinatesShift> result = new HashSet<>();

        result.add(new CoordinatesShift(-1, 0));
        result.add(new CoordinatesShift(0, 1));
        result.add(new CoordinatesShift(1, 0));
        result.add(new CoordinatesShift(0, -1));

        return result;
    }

    @Override
    public String toString() {
        return "[" + rowShift + ", " + columnShift + ']';
    }
}
