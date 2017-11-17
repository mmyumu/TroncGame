package fr.mmyumu.troncgame.model;

/**
 * Constants used by the model
 * Created by mmyumu on 14/02/2016.
 */
public class ModelConstants {
    public class TexturePath {
        public static final String FIST = "data/items/weapons/fist.png";
        public static final String BASIC_SWORD = "data/items/weapons/basic_sword.png";

        private TexturePath() {
            // Private constructor since it's a utility class
        }
    }

    public class DataPath {
        public static final String ITEMS = "data/items.xml";
        public static final String CHARACTERS = "data/characters.xml";
        public static final String THEMES = "data/themes.xml";

        private DataPath() {
            // Private constructor since it's a utility class
        }
    }

    private ModelConstants() {
        // Private constructor since it's a utility class
    }
}
