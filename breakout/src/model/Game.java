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
    private Board board;
    private Ball ball;
    private Paddle paddle;

    public Game() {
        board = new Board(brickWidth, brickHeight, brickRows, brickColumns);
        ball = new Ball(0, 0, ballDiameter);
        paddle = new Paddle(10, 20, paddleWidth, paddleHeight);
    }

    public void advanceGameState() {
        System.out.println("Game.advanceGameState()");
    }

    public Board getBoard() {return board;}

    public Ball getBall() {return ball;}

    public Paddle getPaddle() {return paddle;}
}
