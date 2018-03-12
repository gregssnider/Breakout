package model;

/**
 * Models a wall in the Breakout game.
 *
 * A Wall borders each of the four sides of the playing field (ceiling,
 * floor, left wall, right wall). This is used for collision detection with
 * the ball to implement "bouncing."
 */
public class Wall extends Rectangle {

    /**
     * Create a wall.
     *
     * @see model.Rectangle
     */
    Wall(int x, int y, int width, int height) {
        super(x, y, width, height);
    }
}
