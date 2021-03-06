package model;

/**
 * Models a paddle in the Breakout game.
 */
public class Paddle extends Rectangle {

    /**
     * Create a paddle.
     *
     * @see model.Rectangle
     */
    Paddle(int x, int y, int width, int height) {
        super(x, y, width, height);
    }
}
