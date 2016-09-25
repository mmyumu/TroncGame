package fr.mmyumu.troncgame.fight;

/**
 * Constants for the Fight
 * Created by mmyumu on 23/11/2015.
 */
public interface FightConstants {
    int CHARACTER_WIDTH = 180;
    int CHARACTER_HEIGHT = 180;

    int ICON_WIDTH = 128;
    int ICON_HEIGHT = 128;

    int MAIN_INFOS_WIDTH = 800;
    int MAIN_INFOS_HEIGHT = 250;

    int LABEL_WIDTH = 100;
    int LABEL_HEIGHT = 50;

    interface MusicPath {
        String FIRST_CHIPTUNE = "music/Chiptune2.ogg";
    }

    interface TexturePath {
        String BACKGROUND_PLAIN = "data/fight/background_plain.png";
        String SPELLS_ICON = "data/fight/spells.png";
        String WEAPONS_ICON = "data/fight/icon4.png";
        String MAIN_INFOS = "data/fight/main_infos.png";
        String ACTION_BAR = "data/fight/action_bar.png";
    }

    interface MainInfos {
        int NAME_WIDTH = 300;
        int HP_WIDTH = 100;
        int MP_WIDTH = 100;
        int ROW_HEIGHT = 35;

        // Action bar 160*25 (done with padding)
        int ACTION_BAR_WIDTH = 200;

        int MAX_ACTION_VALUE = 162;
    }
}
