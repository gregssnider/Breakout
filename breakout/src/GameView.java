import java.awt.*;
import javax.swing.*;

import model.*;

/**
 * A graphical view of a Breakout game.
 */
public class GameView extends JPanel {

    private JLabel score;
    private GamePanel gamePanel;
    private Game game;

    /**
     * Construct a view of a game.
     *
     * @param game The game to view
     */
    public GameView(Game game) {
        setLayout(new BorderLayout());
        this.game = game;
        gamePanel = new GamePanel(game);
        score = new JLabel("Score: 0");
        add(score, BorderLayout.NORTH);
        add(gamePanel, BorderLayout.CENTER);
    }

    /** Set the game to be viewed. */
    public void setGame(Game game) {
        this.game = game;
        gamePanel.setGame(game);
    }

    /** Update the view of the game. */
    public void updateView() {
        score.setText("Score: " + game.getScore());
        score.repaint();
        gamePanel.updateView();
    }
}

/**
 * Graphical view of bricks, ball, and paddle.
 */
class GamePanel extends JPanel {

    private Game game;

    GamePanel(Game game) {
        this.game = game;
        setPreferredSize(getPreferredSize());
        setDoubleBuffered(true);
    }

    /** Change the game being viewed. */
    void setGame(Game game) {
        this.game = game;
        updateView();
    }

    /** Update and repaint the view of the game. */
    void updateView() {
        repaint();
    }

    /** Paint the board, ball, and paddle. */
    protected void paintComponent(Graphics g) {
        Toolkit.getDefaultToolkit().sync();
        super.paintComponent(g);
        Board board = game.board;

        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0, 0, board.width, board.height);

        // Paint bricks.
        Brick[][] bricks = board.bricks;
        for (Brick[] row : bricks) {
            for (Brick brick : row) {
                if (brick == null)
                    continue;
                int x = brick.x;
                int y = brick.y;
                int width = brick.width;
                int height = brick.height;
                g.setColor(Color.RED);
                g.fillRect(x, y, width, height);
                g.setColor(Color.BLACK);
                g.drawRect(x, y, width, height);
            }
        }

        // Paint the paddle.
        Paddle paddle = game.paddle;
        g.setColor(Color.BLUE);
        g.fillRect(paddle.x, paddle.y, paddle.width, paddle.height);

        // Paint the ball.
        Ball ball = game.ball;
        g.setColor(Color.BLACK);
        g.fillRect(ball.x, ball.y, ball.width, ball.height);
    }

    public Dimension getPreferredSize() {
        Board board = game.board;
        return new Dimension(board.width, board.height);
    }
}
