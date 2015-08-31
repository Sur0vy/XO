package com.Sur0vy.model;

import com.Sur0vy.felpers.CoordinateChecker;

public class Board {

    private final int FIELD_SIZE = 3;

    private Figure[][] figures = new Figure[FIELD_SIZE][FIELD_SIZE];

//    public Board(int fieldSize){
//        this.fieldSize = fieldSize;
//        Figure[][] figures = new Figure[fieldSize][fieldSize];
//    }

    public Figure getFigure(int x, int y){
        if (CoordinateChecker.checkCoordinate(x) && CoordinateChecker.checkCoordinate(y)) {
            return this.figures[x][y];
        }
        return null;
    }

    public boolean setFigure(int x, int y, Figure figure){
        if (CoordinateChecker.checkCoordinate(x) && CoordinateChecker.checkCoordinate(y)) {
            this.figures[x][y] = figure;
            return true;
        }
        return false;
    }

    public int getFieldSize () {
        return this.FIELD_SIZE;
    }


}
