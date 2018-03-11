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
    private Game game;
    private GameView gameView;
    private JButton startButton;
    private javax.swing.Timer timer;

    GameController() {
        super("Breakout");
        game = new Game();
        gameView = new GameView(game);
        startButton = new JButton("Start");

        // Add components to window
        Container contentPane = getContentPane();
        contentPane.add(gameView, BorderLayout.CENTER);
        contentPane.add(startButton, BorderLayout.SOUTH);

        // Listen for start button presses to (re)start the game.
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Start button pressed");
                game = new Game();
                gameView.setGame(game);
                timer.start();
            }
        } );

        // Listen for mouse events to move paddle.
        gameView.addMouseMotionListener(new MouseMotionListener() {
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

    public void run() {
        while (true) {
            game.advanceGameState();
            gameView.updateView();
            try {
                Thread.sleep(10L);
            } catch (java.lang.InterruptedException e) {
            }
        }
    }
}
