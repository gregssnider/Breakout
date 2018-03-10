package view;
import java.awt.*;
import javax.swing.JPanel;

import model.*;


public class GamePanel extends JPanel {

    private Game game;

    public GamePanel(Game game) {
        this.game = game;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Board board = game.getBoard();
        Brick[][] bricks = board.getBricks();
        for (int row = 0; row < bricks.length; row++) {
            for (int col = 0; col < bricks[0].length; col++) {
                Brick brick = bricks[row][col];
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
    }

    public Dimension getPreferredSize() {
        Board board = game.getBoard();
        return new Dimension(board.getWidth(), board.getHeight());
    }
}
