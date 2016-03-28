package fr.mmyumu.troncgame.model.manager;

import javax.inject.Inject;

import fr.mmyumu.troncgame.model.ModelConstants;

/**
 * Allow to do operations on model
 * Created by mmyumu on 03/03/2016.
 */
public class ModelManager {
    private final ItemManager itemManager;
    private final CharacterManager characterManager;
    private final ThemeManager themeManager;

    @Inject
    public ModelManager(ItemManager itemManager, CharacterManager characterManager, ThemeManager themeManager) {
        this.itemManager = itemManager;
        this.characterManager = characterManager;
        this.themeManager = themeManager;
    }

    public void newGame() {
        characterManager.newTeam();
        characterManager.getTeam().getMainCharacter().getEquipment().equip(itemManager.createWeapon(ItemManager.ID.BASIC_SWORD));
    }

    public ItemManager getItemManager() {
        return itemManager;
    }

    public CharacterManager getCharacterManager() {
        return characterManager;
    }

    public ThemeManager getThemeManager() {
        return themeManager;
    }
}
