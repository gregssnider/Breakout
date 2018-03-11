package model;

public class Game {

    // Geometric parameters of game.
    private static final int brickWidth = 80;
    private static final int brickHeight = 30;
    private static final int brickRows = 4;
    private static final int brickColumns = 11;
    private static final int ballDiameter = 10;
    private static final int paddleWidth = 70;
    private static final int paddleHeight = 10;

    // Components of the game.
    public Board board;
    public Ball ball;
    public Paddle paddle;
    private boolean running = false;

    public Game() {
        board = new Board(brickWidth, brickHeight, brickRows, brickColumns);
        int boardWidth = board.width;
        int boardHeight = board.height;
        ball = new Ball(boardWidth / 2, boardHeight / 2, ballDiameter);
        paddle = new Paddle(10, 20, paddleWidth, paddleHeight);
    }

    public void start() {
        running = true;
    }

    public void advanceGameState() {
        if (!running)
            return;
        ball.move();
        if (ball.intersects(board.leftWall))
            ball.speedX *= -1;
        if (ball.intersects(board.rightWall))
            ball.speedX *= -1;
        if (ball.intersects(board.ceiling))
            ball.speedY *= -1;
        if (ball.intersects(board.floor))
            ball.speedY *= -1;
    }
}
