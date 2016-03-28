package fr.mmyumu.troncgame.dialog;

import fr.mmyumu.troncgame.model.GameCharacter;

/**
 * A character in a dialog with its position
 * Created by mmyumu on 06/03/2016.
 */
public class DialogCharacter {
    private GameCharacter character;
    private DialogSlot slot;

    public DialogCharacter(GameCharacter character, DialogSlot slot) {
        this.character = character;
        this.slot = slot;
    }

    public GameCharacter getCharacter() {
        return character;
    }

    public DialogSlot getSlot() {
        return slot;
    }
}
