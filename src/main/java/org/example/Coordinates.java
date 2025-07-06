package org.example;

import java.util.Objects;

public class Coordinates {
    public final int height;
    public final int width;

    public Coordinates(int height, int width) {
        this.height = height;
        this.width = width;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return Objects.equals(height, that.height) && Objects.equals(width, that.width);
    }

    @Override
    public int hashCode() {
        return Objects.hash(height, width);
    }

    @Override
    public String toString() {
        return "[" + height + ", " + width + ']';
    }


}
