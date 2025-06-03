package org.example;

import org.example.entities.CoordinatesShift;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public final class Coordinates {
    public final int row;
    public final int column;

    public Coordinates(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public Set<CoordinatesShift> getShift() {

        Set<CoordinatesShift> result = new HashSet<>();

        for (int row = -1; row <= 1; row++) {
            for (int column = -1; column < 1; column++) {
                if (row == 0 && column == 0) {
                    continue;
                }
                CoordinatesShift shift = new CoordinatesShift(row, column);
                result.add(shift);
            }
        }
//        Set<CoordinatesShift> result = new HashSet<>();
//
//        for (CoordinatesShift shift : )

//        return result;
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return Objects.equals(row, that.row) && Objects.equals(column, that.column);
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }

    @Override
    public String toString() {
        return "Coordinates[" +
                "row=" + row + ", " +
                "column=" + column + ']';
    }


}
