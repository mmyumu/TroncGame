package fr.mmyumu.troncgame.persistence;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.math.Vector2;

import fr.mmyumu.troncgame.overworld.game.OverworldCharacter;

/**
 * Utility class to save the state of the game
 * Created by mmyumu on 31/01/2016.
 */
public class GameStatePersister {
    public static final String PREF_NAME_OPTION = "gameState";

    private static final String SCREEN = "screen";
    private static final String OVERWORLD_CHARACTER_X = "overworld.character.x";
    private static final String OVERWORLD_CHARACTER_Y = "overworld.character.y";

    private Preferences preferences;

    public GameStatePersister() {
        this.preferences = Gdx.app.getPreferences(PREF_NAME_OPTION);
    }

    public void save(ScreenID screenID) {
        preferences.putInteger(SCREEN, screenID.ordinal());
        preferences.flush();
    }

    public void save(OverworldCharacter mainCharacter) {
        preferences.putFloat(OVERWORLD_CHARACTER_X, mainCharacter.getCenter().x);
        preferences.putFloat(OVERWORLD_CHARACTER_Y, mainCharacter.getCenter().y);

        preferences.flush();
    }

    public ScreenID loadScreen() {
        int ordinal = preferences.getInteger(SCREEN, -1);
        ScreenID screenID = ScreenID.getScreenID(ordinal);

        if (screenID == null) {
            screenID = ScreenID.MAIN_MENU;
        }
        return screenID;
    }

    public Vector2 loadPosition() {
        Float x = preferences.getFloat(OVERWORLD_CHARACTER_X, -1);
        Float y = preferences.getFloat(OVERWORLD_CHARACTER_Y, -1);

        if (x != -1 && y != -1) {
            return new Vector2(x, y);
        }
        return null;
    }

    public void clear() {
        preferences.clear();
        preferences.flush();
    }

    public boolean hasSavedGame() {
        int ordinal = preferences.getInteger(SCREEN, -1);
        return ScreenID.getScreenID(ordinal) != null;
    }
}

