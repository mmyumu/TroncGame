package fr.mmyumu.troncgame.fight;

/**
 * Constants for the Fight
 * Created by mmyumu on 23/11/2015.
 */
public class FightConstants {
    public static final int CHARACTER_WIDTH = 180;
    public static final int CHARACTER_HEIGHT = 180;

    public static final int ICON_WIDTH = 128;
    public static final int ICON_HEIGHT = 128;

    public static final int MAIN_INFOS_WIDTH = 800;
    public static final int MAIN_INFOS_HEIGHT = 250;

    public static final int LABEL_WIDTH = 100;
    public static final int LABEL_HEIGHT = 50;

    public class MusicPath {
        public static final String FIRST_CHIPTUNE = "music/Chiptune2.ogg";

        private MusicPath() {
            // Private constructor since it's a utility class
        }
    }

    public class TexturePath {
        public static final String BACKGROUND_PLAIN = "data/fight/background_plain.png";
        public static final String SPELLS_ICON = "data/fight/spells.png";
        public static final String WEAPONS_ICON = "data/fight/icon4.png";
        public static final String MAIN_INFOS = "data/fight/main_infos.png";
        public static final String ACTION_BAR = "data/fight/action_bar.png";

        private TexturePath() {
            // Private constructor since it's a utility class
        }
    }

    public class MainInfos {
        public static final int NAME_WIDTH = 300;
        public static final int HP_WIDTH = 100;
        public static final int MP_WIDTH = 100;
        public static final int ROW_HEIGHT = 35;

        // Action bar 160*25 (done with padding)
        public static final int ACTION_BAR_WIDTH = 200;

        public static final int MAX_ACTION_VALUE = 162;

        private MainInfos() {
            // Private constructor since it's a utility class
        }
    }

    private FightConstants() {
        // Private constructor since it's a utility class
    }
}
