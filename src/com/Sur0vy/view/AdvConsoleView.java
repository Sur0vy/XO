package com.Sur0vy.view;

import com.Sur0vy.controller.GameController;

public class AdvConsoleView extends ConsoleView {


    public AdvConsoleView(GameController gameController) {
        super(gameController);
    }

    @Override
    public void showGameName() {
        //printStars(false);
        super.showLine(3);
        System.out.print(gameController.getGameName());
    }
}
