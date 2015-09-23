package com.Sur0vy.view;

import com.Sur0vy.model.Field;

import java.awt.*;
import java.util.Random;

public class RandomCoordinateGetter implements ICoordinateGetter {

    private static final Random RANDOM = new Random();

    public Point getMoveCoordinate(final Field field) {
        Point result = getRandomPoint();
//        while (field.getFigure(result) != null) {
//            result = getRandomPoint();
//        }
        result = getRandomPoint();

        return result;
    }

    private Point getRandomPoint() {
        return new Point(
                getRandomInt(),
                getRandomInt()
        );
    }

    private int getRandomInt() {
        return Math.abs(RANDOM.nextInt() % 3);
    }

}

