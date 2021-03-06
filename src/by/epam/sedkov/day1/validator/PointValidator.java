package by.epam.sedkov.day1.validator;

import by.epam.sedkov.day1.entity.PointCoordinate;

public class PointValidator {

    public static boolean isEqualCoordinates(PointCoordinate pointA, PointCoordinate pointB) {
        return Double.compare(pointA.getCoordinateX(), pointB.getCoordinateX()) == 0
                && Double.compare(pointA.getCoordinateY(), pointB.getCoordinateY()) == 0;
    }
}
