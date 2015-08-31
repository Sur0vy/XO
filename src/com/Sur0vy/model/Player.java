package com.Sur0vy.model;

import com.Sur0vy.model.Figure;

public class Player {

    private final String name;

    private final Figure figure;

    public Player(final String name, final Figure figure) {

        assert name != null;
        assert figure != null;

        this.name = name;
        this.figure = figure;
    }

    public String getPlayerName() {
        return this.name;
    }

    public Figure getPlayerFigure() {
        return this.figure;
    }
}
