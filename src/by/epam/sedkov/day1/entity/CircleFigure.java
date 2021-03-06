package by.epam.sedkov.day1.entity;

import java.util.StringJoiner;

public class CircleFigure {
    private double radius;
    private double length;
    private double square;

    public CircleFigure() {
    }

    public CircleFigure(double radius, double length, double square) {
        this.radius = radius;
        this.length = length;
        this.square = square;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getSquare() {
        return square;
    }

    public void setSquare(double square) {
        this.square = square;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        CircleFigure that = (CircleFigure) o;
        if (Math.abs(this.radius - that.radius) > 0.0001) {
            return false;
        }
        if (Math.abs(this.length - that.length) > 0.0001) {
            return false;
        }
        return Math.abs(this.square - that.square) <= 0.0001;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(radius);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(length);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(square);
        result = 31 * result + (int) (temp ^ (temp >> 32));
        return result;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CircleFigure.class.getSimpleName() + "[", "]")
                .add("radius = " + radius)
                .add("length = " + length)
                .add("square = " + square)
                .toString();
    }

}
