package com.Sur0vy.controller;

import com.Sur0vy.model.Field;
import com.Sur0vy.model.Figure;
import com.Sur0vy.model.exceptions.AlreadyOccupaiedException;
import com.Sur0vy.model.exceptions.InvalidPointException;

import java.awt.*;

public class MoveController {

    public void applyFigure(final Field field,
                            final Point point,
                            final Figure figure) throws AlreadyOccupaiedException,
                                                        InvalidPointException {
        if (field.getFigure(point) != null) {
            throw new AlreadyOccupaiedException();
        }
        field.setFigure(point, figure);
    }

}