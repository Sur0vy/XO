package com.Sur0vy.controller;

import com.Sur0vy.model.Field;
import com.Sur0vy.model.Figure;

import java.awt.*;

public class MoveController {

    public boolean applyFigure(final Field field,
                               final Point point,
                               final Figure figure) {
        if (field.getFigure(point) != null)
            return false;
        field.setFigure(point, figure);
        return true;
    }

}