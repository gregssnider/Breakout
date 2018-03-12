package model;

/**
 * Models a board in the Breakout game.
 *
 * For simplicity, Rectangles are used to model just about everything: bricks,
 * paddle, ball, even the playing field itself. "Walls" are placed just outside
 * of the playing field to detect when the ball has hit the edge of the playing
 * field and must bounce back in.
 *
 * Collision detection is done by checking if the ball (a Rectangle) intersects
 * with any other Rectangle (bricks, walls, paddle). When a collision is
 * detected, the velocity of the ball is modified appropriately to model
 * "bouncing." If the ball hits the "floor" wall, the game is over.
 */
public class Board extends Rectangle {

    Wall leftWall;     // Rectangle just to the left of the board.
    Wall rightWall;    // Rectangle just to the right of the board.
    Wall floor;        // Rectangle just below the board.
    Wall ceiling;      // Rectangle just above the board.
    public Brick[][] bricks;  // The bricks on the board.

    /**
     * Construct the Breakout playing field.
     *
     * @param brickWidth Width of each brick, in pixels.
     * @param brickHeight Height of each brick, in pixels.
     * @param brickRows Number of rows of bricks.
     * @param brickColumns Number of columns of bricks.
     */
    Board(int brickWidth, int brickHeight, int brickRows,
                 int brickColumns)
    {
        super(0, 0, brickWidth * brickColumns, brickHeight * brickRows * 6);

        // We want the first row of bricks (from the top) to be spaced down
        // the thickness of 4 bricks. We need gap above bricks for ball to
        // bounce around in.
        int brickStartingRow = 4 * brickHeight;

        // Create bricks.
        bricks = new Brick[brickRows][brickColumns];
        for (int row = 0; row < brickRows; row++) {
            int y = brickStartingRow + row * brickHeight;
            for (int col = 0; col < brickColumns; col++) {
                int x = col * brickWidth;
                bricks[row][col] = new Brick(x, y, brickWidth, brickHeight);
            }
        }

        // Create walls. Make them thick enough that the ball can't accidentally
        // "tunnel through" them if moving quickly.
        int wallThickness = 400;
        floor = new Wall(-wallThickness, height,
                width + 2 * wallThickness, wallThickness);
        ceiling = new Wall(-wallThickness, -wallThickness,
                width + 2 * wallThickness, wallThickness);
        leftWall = new Wall(-wallThickness, 0,
                wallThickness, height);
        rightWall = new Wall(width, 0,
                wallThickness, height);
    }

    /** Test code for Board class. */
    public static void main(String[] args) {
        int brickWidth = 20;
        int brickHeight = 5;
        int brickRows = 4;
        int brickColumns = 11;
        Board board = new Board(brickWidth, brickHeight, brickRows,
                brickColumns);
        Wall[] walls = {board.leftWall, board.rightWall, board.floor,
                board.ceiling};
        for (Wall wall_1 : walls) {
            for (Wall wall_2 : walls) {
                if (wall_1 == wall_2) {
                    check(wall_1.intersects(wall_2));
                    check(wall_2.intersects(wall_1));
                } else {
                    check(!wall_1.intersects(wall_2));
                    check(!wall_2.intersects(wall_1));
                }
            }
        }
        System.out.println("Board tests passed.");
    }

    public static void check(boolean expression) {
        if (!expression) {
            throw new RuntimeException("Test failed.");
        }
    }
}
