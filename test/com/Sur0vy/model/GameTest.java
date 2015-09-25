package com.Sur0vy.model;

import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class GameTest {

    @Test
    public void testGetPlayers() throws Exception {
        final Player[] inputValue = {new Player("Sur0vy", Figure.X), new Player("Second player", Figure.O)};
        final Player[] expectedValue = inputValue;

        final Game game = new Game.Builder().players(inputValue).
                name(null).
                field(null).
                build();
        final Player[] actualValue = game.getPlayers();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testGetField() throws Exception {
        final Field inputValue = new Field();
        final Field expectedValue = inputValue;
        final Player[] players = {new Player(null, null), new Player(null, null)};
        final Game game = new Game.Builder().players(players).
                name(null).
                field(inputValue).
                build();
        final Field actualValue = game.getField();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testGetName() throws Exception {
        final String inputValue = "XO";
        final String expectedValue = inputValue;
        final Player[] players = {new Player(null, null), new Player(null, null)};
        final Game game = new Game.Builder().players(players).
                                            name(inputValue).
                                            field(null).
                                            build();
        final String actualValue = game.getName();
        assertEquals(expectedValue, actualValue);
    }
}