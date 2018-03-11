package controller;

import javax.swing.*;
import model.Game;
import view.GamePanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;


public class GameWindow extends JFrame {

    private Game game;
    private GamePanel gamePanel;
    private JButton startButton;
    private Timer timer;


    public GameWindow() {
        super("Breakout");
        game = new Game();
        gamePanel = new GamePanel(game);
        startButton = new JButton("Start");

        // Add components to window
        Container contentPane = getContentPane();
        contentPane.add(gamePanel, BorderLayout.CENTER);
        contentPane.add(startButton, BorderLayout.SOUTH);

        // Listen for start button presses to start the game.
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Start button pressed");
                timer.start();
            }
        } );

        // Listen for timer to animate the game.
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                System.out.println("timer advanceGameState");
                game.advanceGameState();
                gamePanel.updateView();
            }
        });

        // Listen for mouse events to move paddle.
        gamePanel.addMouseMotionListener(new MouseMotionListener() {
            public void mouseMoved(MouseEvent event) {
                System.out.println("Mouse moved " + event);
            }

            public void mouseDragged(MouseEvent event) {
                System.out.println("Mouse dragged " + event);
            }
        });

        // Set behavior of window.
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
        setResizable(false);
        setVisible(true);
    }
}
