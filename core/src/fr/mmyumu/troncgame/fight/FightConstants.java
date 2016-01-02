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

    int MAIN_INFOS_WIDTH = 614;
    int MAIN_INFOS_HEIGHT = 192;

    interface MusicPath {
        String FIRST_CHIPTUNE = "music/first_chiptune.ogg";
    }

    interface TexturePath {
        String BACKGROUND_PLAIN = "data/fight/background_plain.png";
        String MAIN_CHARACTER = "data/fight/main_character.png";
        String SIDEKICK_CHARACTER = "data/fight/sidekick_character.png";
        String SPELLS_ICON = "data/fight/spells.png";
        String WEAPONS_ICON = "data/fight/weapons.png";
        String MAIN_INFOS = "data/fight/main_infos.png";
    }

    interface MainInfos {
        int NAME_WIDTH = 200;
        int HP_WIDTH = 100;
        int MP_WIDTH = 100;
        int ROW_HEIGHT = 30;
    }
}
