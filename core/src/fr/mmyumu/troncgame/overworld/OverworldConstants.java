package fr.mmyumu.troncgame.overworld;

import java.util.Map;

/**
 * Constants for the Overworld
 * Created by mmyumu on 30/10/2015.
 */
public class OverworldConstants {
    public static final int TILE_WIDTH = 90;
    public static final int TILE_HEIGHT = 90;

    public static final int MENU_LIST_WIDTH = 240;
    public static final int MENU_LIST_HEIGHT = 768;

    public static final String BLOCK = "block";

    public class MapPath {
        public static final String VILLAGE = "maps/outdoor/outdoor.tmx";

        private MapPath() {
            // Private constructor since it's a utility class
        }
    }

    public class TexturePath {
        public static final String MENU_LIST = "data/overworld/menu_list.png";

        private TexturePath() {
            // Private constructor since it's a utility class
        }
    }

    public class SkinPath {
        public static final String SKIN_ATLAS = "data/uiskin.atlas";
        public static final String SKIN_JSON = "data/uiskin.json";

        private SkinPath() {
            // Private constructor since it's a utility class
        }
    }

    private OverworldConstants() {
        // Private constructor since it's a utility class
    }
}
