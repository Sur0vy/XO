package com.Sur0vy.controller;

import com.Sur0vy.model.Field;
import com.Sur0vy.model.Figure;
import com.Sur0vy.model.exceptions.NoWinnerException;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

/**
 * Created by Suvorov on 25.09.2015.
 */
public class WinnerControllerTest {

    @Test
    public void testGetWinnerWhenEmptyField() throws Exception {
        final int fieldSize = 3;
        final WinnerController winnerController = new WinnerController();
        final Field field = new Field(fieldSize);
        try {
            winnerController.getWinner(field);
            fail();
        } catch (NoWinnerException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetWinnerWhenFullFieldButNoWinner() throws Exception {
        final int fieldSize = 3;
        final Field field = new Field(fieldSize);
        final MoveController moveController = new MoveController();
        final WinnerController winnerController = new WinnerController();

        moveController.applyFigure(field, new Point(0, 0), Figure.X);
        moveController.applyFigure(field, new Point(0, 1), Figure.O);
        moveController.applyFigure(field, new Point(0, 2), Figure.X);
        moveController.applyFigure(field, new Point(1, 0), Figure.X);
        moveController.applyFigure(field, new Point(1, 1), Figure.O);
        moveController.applyFigure(field, new Point(1, 2), Figure.O);
        moveController.applyFigure(field, new Point(2, 0), Figure.O);
        moveController.applyFigure(field, new Point(2, 1), Figure.X);
        moveController.applyFigure(field, new Point(2, 2), Figure.X);
        try {
            winnerController.getWinner(field);
            fail();
        } catch (NoWinnerException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetWinnerWhenRowOk() throws Exception {
        final int fieldSize = 3;
        final Field field = new Field(fieldSize);
        final Figure expectedWinner = Figure.X;
        final MoveController moveController = new MoveController();
        final WinnerController winnerController = new WinnerController();
        moveController.applyFigure(field, new Point(0, 0), Figure.O);
        moveController.applyFigure(field, new Point(0, 2), Figure.X);
        moveController.applyFigure(field, new Point(1, 0), Figure.X);
        moveController.applyFigure(field, new Point(1, 1), Figure.X);
        moveController.applyFigure(field, new Point(1, 2), Figure.X);
        moveController.applyFigure(field, new Point(2, 0), Figure.O);
        moveController.applyFigure(field, new Point(2, 1), Figure.O);
        final Figure actualFigure = winnerController.getWinner(field);
        assertEquals(expectedWinner, actualFigure);
    }

    @Test
    public void testGetWinnerWhenColOk() throws Exception {
        final int fieldSize = 3;
        final Field field = new Field(fieldSize);
        final Figure expectedWinner = Figure.O;
        final MoveController moveController = new MoveController();
        final WinnerController winnerController = new WinnerController();
        moveController.applyFigure(field, new Point(0, 0), Figure.O);
        moveController.applyFigure(field, new Point(1, 0), Figure.O);
        moveController.applyFigure(field, new Point(1, 1), Figure.X);
        moveController.applyFigure(field, new Point(1, 2), Figure.X);
        moveController.applyFigure(field, new Point(2, 0), Figure.O);
        moveController.applyFigure(field, new Point(2, 1), Figure.X);
        final Figure actualFigure = winnerController.getWinner(field);
        assertEquals(expectedWinner, actualFigure);
    }

    @Test
    public void testGetWinnerWhenMainDiagOk() throws Exception {
        final int fieldSize = 3;
        final Field field = new Field(fieldSize);
        final Figure expectedWinner = Figure.X;
        final MoveController moveController = new MoveController();
        final WinnerController winnerController = new WinnerController();
        moveController.applyFigure(field, new Point(0, 0), Figure.X);
        moveController.applyFigure(field, new Point(1, 0), Figure.O);
        moveController.applyFigure(field, new Point(1, 1), Figure.X);
        moveController.applyFigure(field, new Point(1, 2), Figure.O);
        moveController.applyFigure(field, new Point(2, 0), Figure.O);
        moveController.applyFigure(field, new Point(2, 2), Figure.X);
        final Figure actualFigure = winnerController.getWinner(field);
        assertEquals(expectedWinner, actualFigure);
    }

    @Test
    public void testGetWinnerWhenAdvDiagOk() throws Exception {
        final int fieldSize = 3;
        final Field field = new Field(fieldSize);
        final Figure expectedWinner = Figure.O;
        final MoveController moveController = new MoveController();
        final WinnerController winnerController = new WinnerController();
        moveController.applyFigure(field, new Point(0, 2), Figure.O);
        moveController.applyFigure(field, new Point(1, 0), Figure.X);
        moveController.applyFigure(field, new Point(1, 1), Figure.O);
        moveController.applyFigure(field, new Point(1, 2), Figure.X);
        moveController.applyFigure(field, new Point(2, 0), Figure.O);
        moveController.applyFigure(field, new Point(2, 2), Figure.X);
        final Figure actualFigure = winnerController.getWinner(field);
        assertEquals(expectedWinner, actualFigure);
    }
}