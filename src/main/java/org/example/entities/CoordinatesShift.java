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

    @Override
    public String toString() {
        return "[" + rowShift + ", " + columnShift + ']';
    }
}
