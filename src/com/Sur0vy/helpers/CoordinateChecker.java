package com.Sur0vy.helpers;

import java.awt.*;

public class CoordinateChecker {

    public static boolean checkPoint (final Point point,
                                      final int minCoordinate,
                                      final int maxCoordinate) {
        return checkCoordinate(point.x, minCoordinate, maxCoordinate) && checkCoordinate(point.y, minCoordinate, maxCoordinate);
    }
    
    private static boolean checkCoordinate(final int coordinate,
                                           final int minCoordinate,
                                           final int maxCoordinate) {
        return coordinate >= minCoordinate && coordinate < maxCoordinate;
    }
}
