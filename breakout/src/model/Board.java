package model;

/**
 * Models a board in the Breakout game.
 */
public class Board extends Rectangle {

    private Wall leftWall;     // Rectangle just to the left of the board.
    private Wall rightWall;    // Rectangle just to the right of the board.
    private Wall floor;        // Rectangle just below the board.
    private Wall ceiling;      // Rectangle just above the board.
    private Brick[][] bricks;  // The bricks on the board.

    public Board(int brickWidth, int brickHeight, int brickRows,
                 int brickColumns)
    {
        super(0, 0, brickWidth * brickColumns, brickHeight * brickRows * 6);

        // We want the first row of bricks (from the top) to be spaced down
        // the thickness of 4 bricks (need gap above bricks for ball to bounce
        // around in.
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

        // Create walls. Make them thick enough that ball can't accidentally
        // "tunnel through" them if moving quickly.
        int wallThickness = 400;
        floor = new Wall(-wallThickness,
                getHeight(),
                getWidth() + 2 * wallThickness,
                wallThickness);
        ceiling = new Wall(-wallThickness,
                -wallThickness,
                getWidth() + 2 * wallThickness,
                wallThickness);
        leftWall = new Wall(-wallThickness,
                0,
                wallThickness,
                getHeight());
        rightWall = new Wall(getWidth(),
                0,
                wallThickness,
                getHeight());
    }
}
