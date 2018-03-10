package model;

/**
 * Models a all in the Breakout game.
 */
public class Ball extends Rectangle {

    /**
     * Create a ball.
     *
     * @see Rectangle class
     */
    public Ball(int x, int y, int diameter) {
        super(x, y, diameter, diameter);
    }
}
