package fr.mmyumu.troncgame.fight;

/**
 * Constants for the Fight
 * Created by mmyumu on 23/11/2015.
 */
public interface FightConstants {
    int CHARACTER_WIDTH = 180;
    int CHARACTER_HEIGHT = 180;


    interface MusicPath {
        String FIRST_CHIPTUNE = "music/first_chiptune.ogg";
    }

    interface TexturePath {
        String BACKGROUND_PLAIN = "data/fight/background_plain.png";
        String MAIN_CHARACTER = "data/fight/main_character.png";
    }
}
