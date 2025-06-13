package org.example.searchPath;

import org.example.entities.CoordinatesShift;

public enum Direction {
    UP(1, 0),
    RIGHT(0,1),
    DOWN(-1,0),
    LEFT(0,-1);


    public final int row;
    public final int column;

    Direction(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public CoordinatesShift shift() {
        return new CoordinatesShift(row, column);
    }
}
