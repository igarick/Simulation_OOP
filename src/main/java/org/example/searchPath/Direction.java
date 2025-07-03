package org.example.searchPath;

import org.example.Coordinates;

public enum Direction {
    UP(1, 0),
    RIGHT(0,1),
    DOWN(-1,0),
    LEFT(0,-1);

    private final Coordinates coordinates;

    Direction(int row, int column) {
        this.coordinates = new Coordinates(row, column);
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }
}
