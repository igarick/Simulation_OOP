package org.example;

import java.util.Objects;

public final class Coordinates {
    public final int row;
    public final int column;

    public Coordinates(int row, int column) {
        this.row = row;
        this.column = column;
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
