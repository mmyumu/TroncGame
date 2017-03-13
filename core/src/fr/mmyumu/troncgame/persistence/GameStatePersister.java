package fr.mmyumu.troncgame.persistence;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.math.Vector2;

import javax.inject.Inject;

import fr.mmyumu.troncgame.model.GameCharacter;
import fr.mmyumu.troncgame.model.Weapon;
import fr.mmyumu.troncgame.model.manager.ModelManager;
import fr.mmyumu.troncgame.overworld.game.OverworldCharacter;

/**
 * Utility class to save the state of the game
 * Created by mmyumu on 31/01/2016.
 */
public class GameStatePersister {
    private static final String PREF_NAME_OPTION = "gameState";

    private static final String SCREEN = "screen";
    private static final String OVERWORLD_CHARACTER_X = "overworld.character.x";
    private static final String OVERWORLD_CHARACTER_Y = "overworld.character.y";
    private static final String CHARACTER_HP = "character.hp";
    private static final String CHARACTER_MP = "character.mp";
    private static final String CHARACTER_EQUIPMENT_WEAPON = "character.equipment.weapon";

    private final ModelManager modelManager;
    private final Preferences preferences;

    @Inject
    public GameStatePersister(ModelManager modelManager) {
        this.modelManager = modelManager;
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

    public void saveModel() {
        saveTeam();
    }

    private void saveTeam() {
        for (GameCharacter character : modelManager.getCharacterManager().getTeam().getCharacters()) {
            saveCharacter(character);
        }
        preferences.flush();
    }

    private void saveCharacter(GameCharacter character) {
        preferences.putInteger(CHARACTER_HP + "." + character.getDefinition().getIdentifier(), character.getCurrentHp());
        preferences.putInteger(CHARACTER_MP + "." + character.getDefinition().getIdentifier(), character.getCurrentMp());

        saveEquipment(character);
    }

    private void saveEquipment(GameCharacter character) {
        Weapon weapon = character.getEquipment().getWeapon();
        if (weapon != null) {
            preferences.putString(CHARACTER_EQUIPMENT_WEAPON + "." + character.getDefinition().getIdentifier(), weapon.getDefinition().getIdentifier());
        }
    }

    public void loadModel() {
        loadTeam();
    }

    private void loadTeam() {
        modelManager.getCharacterManager().newTeam();
        for (GameCharacter character : modelManager.getCharacterManager().getTeam().getCharacters()) {
            loadCharacter(character);
        }
    }

    private void loadCharacter(GameCharacter character) {
        character.setCurrentHp(preferences.getInteger(CHARACTER_HP + "." + character.getDefinition().getIdentifier()));
        character.setCurrentMp(preferences.getInteger(CHARACTER_MP + "." + character.getDefinition().getIdentifier()));

        loadEquipment(character);
    }

    private void loadEquipment(GameCharacter character) {
        String weaponID = preferences.getString(CHARACTER_EQUIPMENT_WEAPON + "." + character.getDefinition().getIdentifier(), null);
        if (weaponID != null) {
            Weapon weapon = modelManager.getItemManager().createWeapon(weaponID);
            character.getEquipment().equip(weapon);
        }
    }
}

