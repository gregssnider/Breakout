package model;

public class Game {

    // Geometric parameters of game.
    public static final int brickWidth = 50;
    public static final int brickHeight = 20;
    public static final int brickRows = 4;
    public static final int brickColumns = 11;
    public static final int ballDiameter = 10;
    public static final int paddleWidth = 70;
    public static final int paddleHeight = 10;

    // Components of the game.
    private Board board;
    private Ball ball;
    private Paddle paddle;

    public Game() {
        board = new Board(brickWidth, brickHeight, brickRows, brickColumns);
        ball = new Ball(0, 0, ballDiameter);
        paddle = new Paddle(10, 20, paddleWidth, paddleHeight);
    }

    public Board getBoard() {return board;}

    public Ball getBall() {return ball;}

    public Paddle getPaddle() {return paddle;}
}
