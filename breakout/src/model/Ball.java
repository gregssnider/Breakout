package model;

/**
 * Models a ball in the Breakout game.
 */
public class Ball extends Rectangle {

    int speedX;  // Speed in the x direction.
    int speedY;  // Speed in the y direction.

    /**
     * Create a ball.
     *
     * @see model.Rectangle
     */
    Ball(int x, int y, int diameter) {
        super(x, y, diameter, diameter);
        speedX = 6;
        speedY = 6;
    }

    /** Move the ball one step in time based on its speed. */
    void move() {
        x += speedX;
        y += speedY;
    }
}
