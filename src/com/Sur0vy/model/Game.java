package com.Sur0vy.model;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Game implements Iterable<Player> {

    private final Player[] players;

    private final Field field;

    private final String name;

    private Game(final Builder builder) {
        this.players = builder.getPlayers();
        this.field = builder.getField();
        this.name = builder.getName();
    }

    public Player[] getPlayers() {
        return this.players;
    }

    public Field getField() {
        return field;
    }

    public String getName() {
        return name;
    }

    @Override
    public Iterator<Player> iterator() {
        return new PlayerIterator();
    }

    private class PlayerIterator implements Iterator<Player>{

        private int index = 0;

        @Override
        public boolean hasNext() {
            return Game.this.players.length > index;
        }

        @Override
        public Player next() {
            return Game.this.players[index++];
        }
    }

    public static class Builder {

        private  Player[] players;

        private  Field field;

        private  String name;

        public Builder players(final Player[] players) {
            this.players = players;
            return this;
        }

        public Builder field(final Field field) {
            this.field = field;
            return this;
        }

        public Builder name(final String name) {
            this.name = name;
            return this;
        }

        public Player[] getPlayers() {
            return this.players;
        }

        public Field getField() {
            return field;
        }

        public String getName() {
            return name;
        }

        public Game build() {
            return new Game(this);
        }
    }

}
