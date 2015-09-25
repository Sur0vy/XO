package com.Sur0vy.model;

import com.Sur0vy.helpers.CoordinateChecker;
import com.Sur0vy.model.exceptions.InvalidPointException;

import java.awt.Point;

public class Field {

    public static final int FIELD_SIZE = 3;

    private static final int MIN_COORDINATE = 0;

    private static final int MAX_COORDINATE = FIELD_SIZE;

    private final Figure[][] figures = new Figure[FIELD_SIZE][FIELD_SIZE];

    public int getSize() {
        return FIELD_SIZE;
    }

    public Figure getFigure(final Point point) throws InvalidPointException {
        if (!CoordinateChecker.checkPoint(point, MIN_COORDINATE, MAX_COORDINATE)) {
            throw new InvalidPointException();
        }
        return figures[point.x][point.y];
    }

    public void setFigure(final Point point, final Figure figure) throws InvalidPointException {
        if (!CoordinateChecker.checkPoint(point, MIN_COORDINATE, MAX_COORDINATE)) {
            throw new InvalidPointException();
        }
        figures[point.x][point.y] = figure;
    }

}