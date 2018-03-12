/**
 * Msin program for the Breakout game.
 *
 * This is structured using the model-view-controller design pattern.
 */
public class Breakout {
    public static void main(String[] argsNotUsed) {
        GameController controller = new GameController();
        controller.run();
    }
}
