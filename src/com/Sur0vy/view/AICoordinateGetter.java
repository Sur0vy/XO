package com.Sur0vy.view;

import com.Sur0vy.model.Field;
import com.Sur0vy.model.Figure;

import java.awt.*;

public class AICoordinateGetter implements ICoordinateGetter {

    public Point getMoveCoordinate(Field field) {

        Point point = getBestPointInDiagonal(field, true);
        if (point != null) {
            return point;
        }
        point = getBestPointInDiagonal(field, false);
        if (point != null) {
            return point;
        }
        point = getBestPointInRow(field);
        if (point != null) {
            return point;
        }
        point = getBestPointInCol(field);
        if (point != null) {
            return point;
        }
        return firstSuitable(field);
    }

    private Point getBestPointInDiagonal (final Field field, final boolean main) {
        Figure figure;
        int count = 0;
        int bestI = -1;
        for (int i = 0; i < field.getSize(); i++) {
            Point point;
            if (main) {
                point = new Point(i, i);
            } else {
                point = new Point(i, field.getSize() - 1 - i);
            }
            figure = field.getFigure(point);
            if (figure == Figure.O) {
                return null;
            }
            if (count == 0) {
                bestI = i;
            }
            if (figure == null) {
                count++;
            }
        }
        if (count == field.getSize()) {
            final int center = field.getSize() % 2;
            return new Point(center, center);
        }
        if (bestI == -1) {
            return null;
        } else {
            if (main) {
                return new Point(bestI, bestI);
            }
            return new Point (bestI, field.getSize() - 1 - bestI);
        }
    }

    private Point getBestPointInRow (final Field field) {
        Figure figure;
        int countX[] = new int[field.getSize()];
        for (int x: countX) {
            x = -1;
        }
        for (int i = 0; i < field.getSize(); i++) {
            for (int j = 0; j < field.getSize(); j++) {
                Point point = new Point(i, j);
                figure = field.getFigure(point);
                if (figure == Figure.O) {
                    countX[i] = -1;
                    break;
                }
                if (figure == Figure.X) {
                    countX[i]++;
                }
            }
        }
        int max = -1;
        int maxI = -1;
        for (int i = 0; i < countX.length; i++) {
            if (max < countX[i]) {
                max = countX[i];
                maxI = i;
            }
        }
        if (max == -1) {
            return null;
        }
        for (int i = 0; i < field.getSize(); i++) {
            if (field.getFigure(new Point(i, max)) == null) {
                return new Point(maxI, i);
            }
        }
        return  null;

    }

    private Point getBestPointInCol (final Field field) {
        Figure figure;
        int countY[] = new int[field.getSize()];
        for (int y: countY) {
            y = -1;
        }
        for (int i = 0; i < field.getSize(); i++) {
            for (int j = 0; j < field.getSize(); j++) {
                Point point = new Point(j, i);
                figure = field.getFigure(point);
                if (figure == Figure.O) {
                    countY[i] = -1;
                    break;
                }
                if (figure == Figure.X) {
                    countY[j] ++;
                }
            }
        }
        int max = -1;
        int maxI = -1;
        for (int i = 0; i < countY.length; i++) {
            if (max < countY[i]) {
                max = countY[i];
                maxI = i;
            }
        }
        if (max == -1) {
            return null;
        }
        for (int i = 0; i < field.getSize(); i++) {
            if (field.getFigure(new Point(max, i)) == null) {
                return new Point(i, maxI);
            }
        }
        return  null;

    }

    private Point firstSuitable(final Field field) {
        Point point;
        for (int i = 0; i < field.getSize(); i++) {
            for (int j = 0; j < field.getSize(); j++) {
                point = new Point(i, j);
                if (field.getFigure(point) == null) {
                    return point;
                }
            }
        }
        return null;
    }
}
