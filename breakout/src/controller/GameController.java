package controller;

import javax.swing.*;
import java.awt.*;
import model.Game;
import view.GamePanel;


public class GameController {

    public static void main(String[] args) {
        Game game = new Game();
        GamePanel gamePanel = new GamePanel(game);

        //1. Create the frame.
        JFrame frame = new JFrame("Breakout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(gamePanel, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }
}
