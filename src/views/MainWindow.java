/*
* File: MainWindow.java
* Author: Nagy József
* Copyright: 2021, Nagy József 
* Date: 2021-09-11
* Licenc: MIT
* refaktoring: Vitovszkit Tamás, Date 2023.12.04
*/
package views;

import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class MainWindow extends JFrame {
    public JButton startBtn = new JButton("Start");
    public JButton stopBtn = new JButton("Stop");
    public JButton nextBtn = new JButton("Következő");
    public JPanel tablePanel = new JPanel();
    public JButton flop1Btn = new JButton("");
    public JButton flop2Btn = new JButton("");
    public JButton flop3Btn = new JButton("");
    public JPanel handPanel = new JPanel();
    public JButton humanCard1Btn = new JButton();
    public JButton humanCard2Btn = new JButton();
    public JPanel buttonPanel = new JPanel();
    public JButton turnButton = new JButton();
    public JButton riverButton = new JButton();

    public MainWindow() {
        initTablePanel();
        initHandPanel();
        initBtnPanel();

        setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 250);
    }

    private void initTablePanel() {
        tablePanel.setSize(100, 100);
        tablePanel.setBackground(Color.LIGHT_GRAY);
        tablePanel.add(flop1Btn);
        tablePanel.add(flop2Btn);
        tablePanel.add(flop3Btn);

        flop1Btn.setVisible(false);
        flop2Btn.setVisible(false);
        flop3Btn.setVisible(false);

        tablePanel.add(turnButton);
        tablePanel.add(riverButton);

        turnButton.setVisible(false);
        riverButton.setVisible(false);

        add(tablePanel);
    }

    private void initHandPanel() {
        handPanel.add(humanCard1Btn);
        handPanel.add(humanCard2Btn);
        add(handPanel);
    }

    private void initBtnPanel() {
        buttonPanel.add(startBtn);
        buttonPanel.add(nextBtn);
        buttonPanel.add(stopBtn);
        add(buttonPanel);
    }
}
