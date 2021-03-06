package model;

/**
 * The top level class of the Breakout game model (using the
 * model-view-controller design pattern).
 */
public class Game {

    // Geometric parameters of game.
    private static final int brickWidth = 80;
    private static final int brickHeight = 30;
    private static final int brickRows = 4;
    private static final int brickColumns = 11;
    private static final int ballDiameter = 10;
    private static final int paddleWidth = 100;
    private static final int paddleHeight = 10;

    // Components of the game.
    public Board board;
    public Ball ball;
    public Paddle paddle;

    // Game state.
    private boolean running = false;
    private boolean gameOver = false;
    private int score = 0;

    /** Construct the game. */
    public Game() {
        board = new Board(brickWidth, brickHeight, brickRows, brickColumns);
        int boardWidth = board.width;
        int boardHeight = board.height;
        ball = new Ball(boardWidth / 2, boardHeight / 2, ballDiameter);
        paddle = new Paddle(boardWidth / 2, boardHeight - brickHeight,
                paddleWidth, paddleHeight);
    }

    /**
     * Move the paddle to a new position.
     *
     * @param xPosition Position of the center of the paddle after the move.
     * @param yPosition Position of the center of the paddle after the move.
     */
    public void movePaddle(int xPosition, int yPosition) {
        // Paddle coordinates start at upper left corner, correct for that.
        int newX = xPosition - paddleWidth / 2;
        if (newX < 0)
            newX = 0;
        if (newX > (board.width - paddle.width))
            newX = board.width - paddle.width;
        paddle.x = newX;
        paddle.y = yPosition - paddleHeight;
    }

    /** Start the game. */
    public void start() {
        running = true;
    }

    /** Get the current score. */
    public int getScore() {
        return score;
    }

    /** Check if game is over. */
    public boolean gameIsOver() {
        return gameOver;
    }

    /** Advance the state of the game by one clock tick. */
    public void advanceGameState() {
        if (!running)
            return;
        ball.move();

        // See if ball hits a wall. If it hits the floor, game is over.
        // Bouncing is implemented by changing the velocity of the ball.
        if (ball.intersects(board.leftWall)) {
            ball.speedX *= -1;  // bounce
            ball.move();
        }
        if (ball.intersects(board.rightWall)) {
            ball.speedX *= -1;  // bounce
            ball.move();
        }
        if (ball.intersects(board.ceiling)) {
            ball.speedY *= -1;  // bounce
            ball.move();
        }
        if (ball.intersects(board.floor)) {
            running = false;
            gameOver = true;
        }

        // See if ball hits the paddle.
        if (ball.intersects(paddle)) {
            ball.speedY *= -1;  // bounce
            ball.move();
        }

        // See if ball hits a brick.
        for (int row = 0; row < board.bricks.length; row++) {
            for (int col = 0; col < board.bricks[0].length; col++) {
                Brick brick = board.bricks[row][col];
                if (brick == null)
                    continue;
                if (ball.intersects(brick)) {
                    // Destroy brick and bounce.
                    board.bricks[row][col] = null;
                    ball.speedY *= -1;
                    ball.move();
                    score++;
                    return;  // Only one brick can be destroyed per tick.
                }
            }
        }
    }
}
