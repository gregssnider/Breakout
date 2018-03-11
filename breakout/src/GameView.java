import java.awt.*;
import javax.swing.JPanel;

import model.*;


public class GameView extends JPanel {

    private Game game;

    GameView(Game game) {
        this.game = game;
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
        super.paintComponent(g);
        Board board = game.board;

        // Paint bricks.
        Brick[][] bricks = board.bricks;
        for (Brick[] row : bricks) {
            for (Brick brick : row) {
                if (brick == null)
                    return;
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
