/*
* File: MainController.java
* Author: Nagy József
* Copyright: 2021, Nagy József 
* Date: 2021-09-11
* Licenc: MIT
* refaktoring: Vitovszkit Tamás, Date 2023.12.04
*/


package controllers;

import java.util.Random;
import views.MainWindow;

public class MainController {

    enum Round {
        PREFLOP,
        FLOP,
        TURN,
        RIVER,
        SHOW
    }

    private final MainWindow mainWindow;
    private final String[] cards = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "B", "D", "K", "A"};
    private Round round = Round.PREFLOP;

    public MainController(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        initEvent();
    }

    private int getRandomCardIndex() {
        Random random = new Random();
        return random.nextInt(cards.length);
    }

    private void setHumanCards() {
        int hcard1 = getRandomCardIndex();
        int hcard2 = getRandomCardIndex();

        String humanCard1Str = cards[hcard1];
        String humanCard2Str = cards[hcard2];

        mainWindow.humanCard1Btn.setText(humanCard1Str);
        mainWindow.humanCard2Btn.setText(humanCard2Str);

        System.out.printf("%d %d\n", hcard1, hcard2);
    }

    private void showFlop() {
        int flop1 = getRandomCardIndex();
        int flop2 = getRandomCardIndex();
        int flop3 = getRandomCardIndex();

        String flop1Str = cards[flop1];
        String flop2Str = cards[flop2];
        String flop3Str = cards[flop3];

        mainWindow.flop1Btn.setText("♦" + flop1Str);
        mainWindow.flop2Btn.setText(flop2Str);
        mainWindow.flop3Btn.setText(flop3Str);

        mainWindow.flop1Btn.setVisible(true);
        mainWindow.flop2Btn.setVisible(true);
        mainWindow.flop3Btn.setVisible(true);

        round = Round.FLOP;
    }

    private void showTurn() {
        int turn = getRandomCardIndex();
        mainWindow.turnButton.setText(cards[turn]);
        mainWindow.turnButton.setVisible(true);

        round = Round.TURN;
    }

    private void showRiver() {
        int river = getRandomCardIndex();
        mainWindow.riverButton.setText(cards[river]);
        mainWindow.riverButton.setVisible(true);

        round = Round.RIVER;
    }

    public void initEvent() {
        mainWindow.startBtn.addActionListener(event -> setHumanCards());

        mainWindow.stopBtn.addActionListener(event -> System.out.println("Állj"));

        mainWindow.nextBtn.addActionListener(event -> {
            if (round == Round.PREFLOP) {
                showFlop();
            } else if (round == Round.FLOP) {
                showTurn();
            } else if (round == Round.TURN) {
                showRiver();
            }
        });
    }
}
