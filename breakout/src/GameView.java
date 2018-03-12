import java.awt.*;
import javax.swing.*;

import model.*;

/**
 * Graphical view of Breakout: bricks, ball, paddle, and score.
 */
class GameView extends JPanel {

    // The game being viewed.
    private Game game;

    /** Construct a view of 'game'. */
    GameView(Game game) {
        this.game = game;
        //setPreferredSize(getPreferredSize());
        //setDoubleBuffered(true);
    }

    /** Change the game being viewed. */
    void setGame(Game game) {
        this.game = game;
        repaint();
    }

    /** Paint the board, ball, and paddle. */
    protected void paintComponent(Graphics g) {
        Toolkit.getDefaultToolkit().sync();
        super.paintComponent(g);
        Board board = game.board;

        // Paint a darker background.
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0, 0, board.width, board.height);

        // Paint score.
        g.setColor(Color.BLACK);
        String score = "Score: " + game.getScore();
        if (game.gameIsOver())
            score += "   GAME OVER";
        Font font = g.getFont().deriveFont( 20.0f );
        g.setFont(font);
        g.drawString(score, 10, 30);

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

    /** Get the size of the playing field. */
    public Dimension getPreferredSize() {
        Board board = game.board;
        return new Dimension(board.width, board.height);
    }
}
