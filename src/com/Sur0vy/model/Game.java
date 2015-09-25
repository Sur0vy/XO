package com.Sur0vy.model;

public class Game {

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
