package life.main;

import java.awt.*;

public class Config {
    public static final int SIZE = 10;
    public static final int WIDTH = 80;
    public static final int HEIGHT = 60;
    public static final int SLEEP = 400;

    public static Color getColor (Status status) {
        switch (status) {
            default:
            case NONE: return Color.GRAY;
            case BORN: return Color.GREEN;
            case LIVE: return Color.WHITE;
            case DIED: return Color.RED;
        }
    }
}
