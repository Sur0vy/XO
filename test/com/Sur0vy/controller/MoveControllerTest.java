package com.Sur0vy.controller;

import com.Sur0vy.model.Field;
import com.Sur0vy.model.Figure;
import com.Sur0vy.model.exceptions.AlreadyOccupaiedException;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class MoveControllerTest {

    @Test
    public void testSetFigureWhenAlreadyOccupaied() throws Exception {

        final MoveController moveController = new MoveController();
        final Field field = new Field(3);
        final Point inputPoint = new Point(0, 0);

        moveController.applyFigure(field, inputPoint, Figure.O);
        try {
            moveController.applyFigure(field, inputPoint, Figure.O);
            fail();
        } catch (final AlreadyOccupaiedException e) {}
    }

}