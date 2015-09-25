package com.Sur0vy.model;

import com.Sur0vy.helpers.CoordinateChecker;
import com.Sur0vy.model.exceptions.InvalidPointException;

import java.awt.Point;

public class Field {

    private static final int MIN_COORDINATE = 0;

    private final Figure[][] figures;

    private final int fieldSise;

    public Field(int fieldSise) {
        this.fieldSise = fieldSise;
        figures = new Figure[fieldSise][fieldSise];
    }

    public int getSize() {
        return fieldSise;
    }

    public Figure getFigure(final Point point) throws InvalidPointException {
        if (!CoordinateChecker.checkPoint(point, MIN_COORDINATE, fieldSise)) {
            throw new InvalidPointException();
        }
        return figures[point.x][point.y];
    }

    public void setFigure(final Point point, final Figure figure) throws InvalidPointException {
        if (!CoordinateChecker.checkPoint(point, MIN_COORDINATE, fieldSise)) {
            throw new InvalidPointException();
        }
        figures[point.x][point.y] = figure;
    }

}