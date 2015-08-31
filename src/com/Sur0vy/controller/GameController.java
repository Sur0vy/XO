package com.Sur0vy.controller;

import com.Sur0vy.felpers.CoordinateChecker;
import com.Sur0vy.model.Board;
import com.Sur0vy.model.Player;

public class GameController {

    private static final String DEFAULT_GAME_NAME = "XO";

    private final String gameName;

    private final Board board;

    private static final String X_FIGURE = "X";

    private static final String O_FIGURE = "O";

    private Player[] players;

    public GameController (final String gameName, final Player[] players, final Board board) {
        if (gameName == null || gameName.isEmpty() ) {
            this.gameName = DEFAULT_GAME_NAME;
        } else {
            this.gameName = gameName;
        }

        assert players != null;
        assert board != null;

        this.players = players;
        this.board = board;
    }

    public String getGameName() {
        return this.gameName;
    }

    public Player[] getPlayers() {
        return this.players;
    }

    public Player currentPlayer() {
        int xCount = 0;
        int oCount = 0;
        for (int i = 0; i < this.board.getFieldSize(); i ++) {
            for (int j = 0; j < this.board.getFieldSize(); j ++) {
                if (this.board.getFigure(i, j) != null) {
                    if (this.board.getFigure(i, j).toString() == X_FIGURE) {
                        xCount ++;
                    } else if (this.board.getFigure(i, j).toString() == O_FIGURE) {
                        oCount ++;
                    }
                }
            }
        }

        boolean xMove;

        if (xCount > oCount){
            xMove = false;
        } else {
            xMove = true;
        }

        for (int i = 0; i < this.players.length; i ++) {
            if ((xMove && this.players[i].getPlayerFigure().toString() == X_FIGURE) || (!xMove && this.players[i].getPlayerFigure().toString() == O_FIGURE))  {
                return this.players[i];
            }
        }
        return null;
    }

    public boolean move(final int x, final int y) {

        assert (x >= 0) && (y >= 0);

        if (CoordinateChecker.checkCoordinate(x) && CoordinateChecker.checkCoordinate(y)) {
            //TODO move logic

            return true;
        }
        return false;
    }

    public Board getBoard() {
        return this.board;
    }

    public Player winner(){
        for (int i = 0; i < this.players.length; i ++) {
            if (isWinner(this.players[i])) {
                return this.players[i];
            }
        }
        return null;
    }

    private boolean isWinner (Player player) {

        if (checkWinnerRows(player.getPlayerFigure().toString())) {
            return true;
        }
        if (checkWinnerCols(player.getPlayerFigure().toString())) {
            return true;
        }
        if (checkWinnerMainDiag(player.getPlayerFigure().toString())) {
            return true;
        }
        if (checkWinnerMinorDiag(player.getPlayerFigure().toString())) {
            return true;
        }
        return false;
    }

    private boolean checkWinnerRows(String figure) {
        for (int i = 0; i < this.board.getFieldSize(); i ++) {
            if (checkWinnerRow(i, figure)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkWinnerRow (int rowIndex, String figure) {
        for (int i = 0; i < this.board.getFieldSize(); i ++) {
            if (this.board.getFigure(i, rowIndex) == null || this.board.getFigure(i, rowIndex).toString() != figure) {
                return false;
            }
        }
        return true;
    }

    private boolean checkWinnerCols(String figure) {
        for (int i = 0; i < this.board.getFieldSize(); i ++) {
            if (checkWinnerCol(i, figure)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkWinnerCol (int colIndex, String figure) {
        for (int i = 0; i < this.board.getFieldSize(); i ++) {
            if (this.board.getFigure(colIndex, i) == null || this.board.getFigure(colIndex, i).toString() != figure) {
                return false;
            }
        }
        return true;
    }

    private boolean checkWinnerMainDiag(String figure) {

        for (int i = 0; i < this.board.getFieldSize(); i ++){
            if (this.board.getFigure(i, i) == null ||this.board.getFigure(i, i).toString() != figure) {
                return false;
            }
        }

        return true;
    }

    private boolean checkWinnerMinorDiag(String figure) {

        for (int i = 0; i < this.board.getFieldSize(); i ++){
            if (this.board.getFigure(i, this.board.getFieldSize() - i) == null || this.board.getFigure(i, this.board.getFieldSize() - i).toString() != figure) {
                return false;
            }
        }
        return true;
    }

}
