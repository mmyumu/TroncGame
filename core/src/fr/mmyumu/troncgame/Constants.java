package fr.mmyumu.troncgame;

/**
 * General game constants
 * Created by mmyumu on 27/10/2015.
 */
public class Constants {
    public static final int WIDTH = 1920;
    public static final int HEIGHT = 1080;

    public class TexturePath {
        public static final String MAIN_MENU = "data/main_menu.png";
        public static final String LOADING = "data/loading_screen.png";
    }

    public class FontPath {
        public static final String PRESS_START_2P = "fonts/PressStart2P.ttf";
        public static final String BM_BLOCK = "fonts/BMblock.TTF";
        public static final String KARMATIC_ARCADE = "fonts/ka1.ttf";
        public static final String VISITOR = "fonts/visitor1.ttf";
    }

    public static final String KINGDOM = "Takeln";

    private Constants() {
        // Private constructor since it's a utility class
    }
}
