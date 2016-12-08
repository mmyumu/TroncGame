package fr.mmyumu.troncgame;

/**
 * General game constants
 * Created by mmyumu on 27/10/2015.
 */
public interface Constants {
    int WIDTH = 1920;
    int HEIGHT = 1080;

    interface TexturePath {
        String MAIN_MENU = "data/main_menu.png";
        String LOADING = "data/loading_screen.png";
    }

    interface FontPath {
        String PRESS_START_2P = "fonts/PressStart2P.ttf";
        String BM_BLOCK = "fonts/BMblock.TTF";
        String KARMATIC_ARCADE = "fonts/ka1.ttf";
        String VISITOR = "fonts/visitor1.ttf";
    }

    String KINGDOM = "Takeln";
}
