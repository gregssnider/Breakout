package model;

/**
 * Models a all in the Breakout game.
 */
public class Ball extends Rectangle {

    public int speedX;  // Speed in the x direction.
    public int speedY;  // Speed in the y direction.

    /**
     * Create a ball.
     *
     * @see Rectangle class
     */
    public Ball(int x, int y, int diameter) {
        super(x, y, diameter, diameter);
        speedX = 5;
        speedY = 5;
    }

    /** Move the ball one step in time based on its speed. */
    public void move() {
        x += speedX;
        y += speedY;
    }
}
