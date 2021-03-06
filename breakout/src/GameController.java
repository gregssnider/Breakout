import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import model.Game;

/**
 * Controller for Breakout.
 */
class GameController extends JFrame {
    private Game game;            // The model.
    private GameView gameView;    // The view.
    private JButton startButton;

    /** Constructor. */
    GameController() {
        super("Breakout");
        game = new Game();
        gameView = new GameView(game);
        startButton = new JButton("Start");

        // Add components to window.
        Container contentPane = getContentPane();
        contentPane.add(gameView, BorderLayout.CENTER);
        contentPane.add(startButton, BorderLayout.SOUTH);

        // Listen for start button presses to start the game.
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                game = new Game();
                gameView.setGame(game);
                game.start();
            }
        } );

        // Listen for mouse events to move paddle.
        gameView.addMouseMotionListener(new MouseMotionListener() {
            public void mouseMoved(MouseEvent event) {
                game.movePaddle(event.getX(), event.getY());
            }

            public void mouseDragged(MouseEvent event) {
            }
        });

        // Set behavior of window.
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
        setResizable(false);
        setVisible(true);
    }

    /**
     * Run the game until user closes the window.
     */
    void run() {
        while (true) {
            game.advanceGameState();
            gameView.repaint();
            try {
                Thread.sleep(10L);
            } catch (java.lang.InterruptedException e) {
            }
        }
    }
}
