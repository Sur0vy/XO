package com.Sur0vy.felpers;

/**
 * Created by Suvorov on 26.08.2015.
 */
public class CoordinateChecker {

    private static final int MIN_COORDINATE = 0;

    private static final int MAX_COORDINATE = 2;

    public static boolean checkCoordinate(final int coordinate) {
        return(!(coordinate < MIN_COORDINATE || coordinate > MAX_COORDINATE));
    }
}
