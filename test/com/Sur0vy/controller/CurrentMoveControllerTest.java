package com.Sur0vy.controller;

import com.Sur0vy.model.Field;
import com.Sur0vy.model.Figure;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class CurrentMoveControllerTest {

    @Test
    public void testCurrentMoveWhenNextMoveIsO() throws Exception {
        final CurrentMoveController currentMoveController = new CurrentMoveController();
        final MoveController moveController = new MoveController();
        final int fieldSize = 3;
        for (int i = 0; i < fieldSize; i++) {
            final Field field = new Field(fieldSize);
            moveController.applyFigure(field, new Point(i, 0), Figure.O);
            moveController.applyFigure(field, new Point(i, 1), Figure.X);
            moveController.applyFigure(field, new Point(i, 2), Figure.X);
            assertEquals(Figure.O, currentMoveController.currentMove(field));
        }
    }

    @Test
    public void testCurrentMoveWhenNextMoveIsX() throws Exception {
        final CurrentMoveController currentMoveController = new CurrentMoveController();
        final MoveController moveController = new MoveController();
        final int fieldSize = 3;
        for (int i = 0; i < fieldSize; i++) {
            final Field field = new Field(fieldSize);
            moveController.applyFigure(field, new Point(i, 0), Figure.O);
            moveController.applyFigure(field, new Point(i, 1), Figure.X);
            assertEquals(Figure.X, currentMoveController.currentMove(field));
        }
    }

    @Test
    public void testCurrentMoveWheNoNextMove() throws Exception {
        final CurrentMoveController currentMoveController = new CurrentMoveController();
        final MoveController moveController = new MoveController();
        final Field field = new Field(3);
        moveController.applyFigure(field, new Point(0, 0), Figure.X);
        moveController.applyFigure(field, new Point(0, 1), Figure.O);
        moveController.applyFigure(field, new Point(0, 2), Figure.X);
        moveController.applyFigure(field, new Point(1, 0), Figure.X);
        moveController.applyFigure(field, new Point(1, 1), Figure.O);
        moveController.applyFigure(field, new Point(1, 2), Figure.O);
        moveController.applyFigure(field, new Point(2, 0), Figure.O);
        moveController.applyFigure(field, new Point(2, 1), Figure.X);
        moveController.applyFigure(field, new Point(2, 2), Figure.X);
        assertNull(currentMoveController.currentMove(field));
    }
}