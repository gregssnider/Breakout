package view;
import java.awt.*;
import javax.swing.JPanel;

import model.Game;
import model.Ball;
import model.Board;
import model.Paddle;


public class GamePanel extends JPanel {

    private Game game;

    public GamePanel(Game game) {
        this.game = game;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawRect(230,80,10,10);
        g.setColor(Color.RED);
        g.fillRect(230,80,10,10);
    }

    public Dimension getPreferredSize() {
        Board board = game.getBoard();
        return new Dimension(board.getWidth(), board.getHeight());
    }
}
