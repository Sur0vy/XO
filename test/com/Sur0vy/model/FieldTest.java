package com.Sur0vy.model;

import com.Sur0vy.model.exceptions.AlreadyOccupaiedException;
import com.Sur0vy.model.exceptions.InvalidPointException;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

/**
 * Created by Suvorov on 23.09.2015.
 */
public class FieldTest {

    @Test
    public void testGetSize() throws Exception {
        final Field field = new Field();

        assertEquals(3, field.getSize());
    }

    @Test
    public void testSetFigure() throws Exception {
        final Field field = new Field();
        final Point  inputPoint = new Point(0, 0);
        final Figure inputFigure = Figure.O;

        field.setFigure(inputPoint, inputFigure);

        final Figure actualFigure = field.getFigure(inputPoint);

        assertEquals(inputFigure, actualFigure);

    }

    @Test
    public void testGetFigureWhenFigureIsNosSet() throws Exception {
        final Field field = new Field();
        final Point  inputPoint = new Point(0, 0);

        final Figure actualFigure = field.getFigure(inputPoint);

        assertNull(actualFigure);
    }


    @Test
    public void testGetFigureWhenXIsLessThenZero() throws Exception {
        final Field field = new Field();
        final Point  inputPoint = new Point(-1, 0);

        try {
            field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e) {};
    }

    @Test
         public void testGetFigureWhenYIsLessThenZero() throws Exception {
        final Field field = new Field();
        final Point  inputPoint = new Point(0, -1);

        try {
            field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e) {};
    }

    @Test
    public void testGetFigureWhenCoordinatesIsLessThenZero() throws Exception {
        final Field field = new Field();
        final Point  inputPoint = new Point(-1, -1);

        try {
            field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e) {};
    }

    @Test
    public void testGetFigureWhenXIsMoreThenSize() throws Exception {
        final Field field = new Field();
        final Point  inputPoint = new Point(field.getSize() + 1, 0);

        try {
            field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e) {};
    }

    @Test
    public void testGetFigureWhenYIsMoreThenSize() throws Exception {
        final Field field = new Field();
        final Point  inputPoint = new Point(0, field.getSize() + 1);

        try {
            field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e) {};
    }

    @Test
    public void testGetFigureWhenCoordinatesIsMoreThenSize() throws Exception {
        final Field field = new Field();
        final Point  inputPoint = new Point(field.getSize() + 1, field.getSize() + 1);

        try {
            field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e) {};
    }

    @Test
    public void testSetFigureWhenAlreadyOccupied() throws Exception {
        final Field field = new Field();
        final Point  inputPoint = new Point(0, 0);
        final Figure inputFigure = Figure.O;

        field.setFigure(inputPoint,inputFigure);
        try {
            field.setFigure(inputPoint, inputFigure);
            fail();
        } catch (final AlreadyOccupaiedException e) {};
    }
}