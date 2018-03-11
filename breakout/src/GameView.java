import java.awt.*;
import javax.swing.JPanel;

import model.*;


public class GameView extends JPanel {

    private Game game;

    GameView(Game game) {
        this.game = game;
    }

    void updateView() {
        repaint();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Board board = game.getBoard();

        // Paint bricks.
        Brick[][] bricks = board.getBricks();
        for (Brick[] row : bricks) {
            for (Brick brick : row) {
                if (brick == null)
                    return;
                int x = brick.getX();
                int y = brick.getY();
                int width = brick.getWidth();
                int height = brick.getHeight();
                g.setColor(Color.RED);
                g.fillRect(x, y, width, height);
                g.setColor(Color.BLACK);
                g.drawRect(x, y, width, height);
            }
        }

        // Paint paddle.

        // Paint ball.
    }

    public Dimension getPreferredSize() {
        Board board = game.getBoard();
        return new Dimension(board.getWidth(), board.getHeight());
    }
}
