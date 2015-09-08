package com.Sur0vy.model;

public enum Figure {

    X("X"), O("O");

    private final String figure;

    Figure(final String figure) {
        assert (figure != null && !figure.isEmpty());

        this.figure = figure;
    }

    public String getFigure() {
        return figure;
    }

//    @Override
//    public String toString(){
//        return this.figure;
//    }

}
