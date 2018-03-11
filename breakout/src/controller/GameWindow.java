package controller;

import javax.swing.*;
import model.Game;
import view.GamePanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GameWindow extends JFrame implements ActionListener {

    private Game game;
    private GamePanel gamePanel;
    private JToolBar toolbar;
    private JButton startButton;

    public GameWindow() {
        super("Breakout");
        game = new Game();
        gamePanel = new GamePanel(game);
        getContentPane().add(gamePanel, BorderLayout.CENTER);
        startButton = new JButton("Start");
        startButton.addActionListener(this);
        toolbar = new JToolBar();
        toolbar.setFloatable(false);
        toolbar.add(startButton);
        getContentPane().add(toolbar, BorderLayout.NORTH);

        // Set behavior of window.
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
        setResizable(false);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        System.out.println("Button pressed");
    }
}
