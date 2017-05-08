package View;

import Model.Engine;

/**
 * Created by sabra on 05/05/17.
 */
public class MainWindow {

    public static void main(String[] args) {
        Engine engine = new Engine();
        StartWindow begin = new StartWindow();
        begin.pack();
        begin.setVisible(true);
    }
}
