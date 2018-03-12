/**
 * Breakout game program.
 *
 * This is structured using the model-view-controller design pattern.
 *
 *    model:      implemented in model package.
 *    view:       implemented in GameView class.
 *    controller: implemented in GameController class.
 */
public class Breakout {

    /** Create the Breakout game and run it until the user closes the window. */
    public static void main(String[] argsNotUsed) {
        GameController controller = new GameController();
        controller.run();
    }
}
