package com.Sur0vy.model;

import java.awt.Point;

public class Field {

    public static final int FIELD_SIZE = 3;

    private final Figure[][] figures = new Figure[FIELD_SIZE][FIELD_SIZE];

    public int getSize() {
        return figures.length;
    }

    public Figure getFigure(final Point point) {
        return figures[point.x][point.y];
    }

    public void setFigure(final Point point, final Figure figure) {
        figures[point.x][point.y] = figure;
    }

}