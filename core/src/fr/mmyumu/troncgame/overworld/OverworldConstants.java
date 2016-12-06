package fr.mmyumu.troncgame.overworld;

/**
 * Constants for the Overworld
 * Created by mmyumu on 30/10/2015.
 */
public final class OverworldConstants {
    public static final int TILE_WIDTH = 90;
    public static final int TILE_HEIGHT = 90;

    public static final int MENU_LIST_WIDTH = 240;
    public static final int MENU_LIST_HEIGHT = 768;

    public static final String BLOCK = "block";

    public static final String ENTRANCE_LAYER = "Entrances";

    public class TexturePath {
        public static final String MENU_LIST = "data/overworld/menu_list.png";
    }

    public class SkinPath {
        public static final String SKIN_ATLAS = "data/uiskin.atlas";
        public static final String SKIN_JSON = "data/uiskin.json";
    }

    private OverworldConstants() {
    }
}
