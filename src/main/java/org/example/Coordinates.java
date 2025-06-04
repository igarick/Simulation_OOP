package org.example;

import org.example.entities.CoordinatesShift;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Coordinates {
    public final Integer row;
    public final Integer column;

    public Coordinates(Integer row, Integer column) {
        this.row = row;
        this.column = column;
    }

    public boolean canShift(CoordinatesShift shift) {
        int r = row + shift.rowShift;
        int c = column + shift.columnShift;

        if ((r < 0 || r > FieldSize.ROW_COUNT) ||
            (c < 0 || c > FieldSize.COLUMN_COUNT)) {
            return false;
        }

        return true;
    }

    public Coordinates shift(CoordinatesShift shift) {
        return new Coordinates(row + shift.rowShift, column + shift.columnShift);
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
