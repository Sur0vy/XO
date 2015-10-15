package com.Sur0vy.controller;

import com.Sur0vy.model.Field;
import com.Sur0vy.model.Figure;
import com.Sur0vy.model.exceptions.InvalidPointException;

import java.awt.*;

public class CurrentMoveController {

    public Figure currentMove(final Field field){
        int countFigure = 0;
        for (int x = 0; x < field.getSize(); x++) {
            try {
                countFigure += countFiguresInTheRow(field, x);
            } catch (InvalidPointException e) {
                e.printStackTrace();
            }
        }

        if (countFigure == field.getSize() * field.getSize())
            return null;

        if (countFigure % 2 == 0)
            return Figure.X;

        return Figure.O;
    }

    private int countFiguresInTheRow(final Field field, final Integer row) throws InvalidPointException {
        int countFigure = 0;
        for (int x = 0; x < field.getSize(); x++) {
            final Point p = new Point(x, row);
            if (field.getFigure(p) != null)
                countFigure++;
        }
        return countFigure;
    }

}
