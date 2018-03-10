package model;

public class Game {

    // Geometric parameters of game.
    public static final int brickWidth = 50;
    public static final int brickHeight = 20;
    public static final int brickRows = 4;
    public static final int brickColumns = 11;
    //public static final int boardWidth = brickWidth * brickColumns;
    //public static final int boardHeight = brickHeight * 24;
    public static final int ballWidth = 10;
    public static final int ballHeight = 10;
    public static final int paddleWidth = 70;
    public static final int paddleHeight = 10;

    private Board board;
    private Ball ball;
    private Paddle paddle;

    public Game() {

    }

}
