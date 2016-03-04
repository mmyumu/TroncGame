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

    @Inject
    public ModelManager(ItemManager itemManager, CharacterManager characterManager) {
        this.itemManager = itemManager;
        this.characterManager = characterManager;
    }

    public void newGame() {
        characterManager.newTeam();
        characterManager.getTeam().getMainCharacter().getEquipment().equip(itemManager.getWeapon(ModelConstants.Identifier.BASIC_SWORD));
    }

    public ItemManager getItemManager() {
        return itemManager;
    }

    public CharacterManager getCharacterManager() {
        return characterManager;
    }
}
