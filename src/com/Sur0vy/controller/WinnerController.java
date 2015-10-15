package com.Sur0vy.controller;

import com.Sur0vy.model.Field;
import com.Sur0vy.model.Figure;
import com.Sur0vy.model.exceptions.InvalidPointException;
import com.Sur0vy.model.exceptions.NoWinnerException;

import java.awt.*;


public class WinnerController {

    public Figure getWinner(final Field field) throws NoWinnerException {
        Figure winner;
        try {
            winner = checkRows(field);
            if (null != winner) {
                return winner;
            }
            winner = checkCols(field);
            if (null != winner) {
                return winner;
            }
            winner = checkMainDiagonal(field);
            if (null != winner) {
                return winner;
            }
            winner = checkAdvDiagonal(field);
            if (null != winner) {
                return winner;
            }
        } catch (InvalidPointException e) {
            e.printStackTrace();
        }
        throw new NoWinnerException();
    }

    private Figure checkRows(final Field field) throws InvalidPointException{
        for (int i = 0; i < field.getSize(); i++) {
            if (check(field, new Point(i, 0), p -> new Point(p.x, p.y + 1))) {
                return field.getFigure(new Point(i, 0));
            }
        }
        return null;
    }

    private Figure checkCols(final Field field) throws InvalidPointException{
        for (int i = 0; i < field.getSize(); i++) {
            if (check(field, new Point(0, i), p -> new Point(p.x + 1, p.y))) {
                return field.getFigure(new Point(0, i));
            }
        }
        return null;
    }

    private Figure checkMainDiagonal(final Field field) throws InvalidPointException{
        for (int i = 0; i < field.getSize(); i++) {
            if (check(field, new Point(0, 0), p -> new Point(p.x + 1, p.y + 1))) {
                return field.getFigure(new Point(0, 0));
            }
        }
        return null;
    }

    private Figure checkAdvDiagonal(final Field field) throws InvalidPointException{
        for (int i = 0; i < field.getSize(); i++) {
            if (check(field, new Point(0, field.getSize() - 1), p -> new Point(p.x + 1, p.y - 1))) {
                return field.getFigure(new Point(0, field.getSize() - 1));
            }
        }
        return null;
    }

    private boolean check(final Field field, final Point currentPoint, final IPointGenerator pointGenerator) {
        final Figure currentFigure;
        final Figure nextFigure;
        final Point nextPoint = pointGenerator.next(currentPoint);
        try {
            currentFigure = field.getFigure(currentPoint);

            if (currentFigure == null) {
                return false;
            }

            nextFigure = field.getFigure(nextPoint);
        } catch (final InvalidPointException e) {
            return true;
        }

        if (currentFigure != nextFigure) {
            return false;
        }
        return check(field, nextPoint, pointGenerator);
    }

    private interface IPointGenerator {
        public Point next(final Point point);
    }

}
