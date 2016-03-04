package fr.mmyumu.troncgame.model;

import com.badlogic.gdx.Gdx;

/**
 * Instance of a character of the game
 * Created by mmyumu on 04/03/2016.
 */
public class GameCharacter {
    private static final String TAG = "GameCharacter";

    private GameCharacterDef definition;

    private String name;

    private int currentHp;
    private int currentMp;

    private Equipment equipment;

    public GameCharacter(GameCharacterDef characterDef) {
        this.equipment = new Equipment();
        this.definition = characterDef;
        this.currentHp = characterDef.getHp();
        this.currentMp = characterDef.getMp();
    }

    public int attack(GameCharacter character) {
        int totalAttack = definition.getAttack();
        Weapon weapon = equipment.getWeapon();
        if (weapon != null) {
            totalAttack += weapon.getDefinition().getAttack();
        }
        character.setCurrentHp(character.getCurrentHp() - totalAttack);
        Gdx.app.debug(TAG, definition.getName() + " is attacking " + character.getDefinition().getName() + " for " + totalAttack + " damage. " + character.getDefinition().getHp() + "HP left.");
        return totalAttack;
    }

    public String retrieveName() {
        if (name == null) {
            return definition.getName();
        }
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCurrentMp() {
        return currentMp;
    }

    public void setCurrentMp(int currentMp) {
        this.currentMp = currentMp;
    }

    public int getCurrentHp() {
        return currentHp;
    }

    public void setCurrentHp(int currentHp) {
        this.currentHp = currentHp;
    }

    public GameCharacterDef getDefinition() {
        return definition;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public double getActionSpeed() {
        // TODO: compute equipment + definition actionSpeed
        return definition.getActionSpeed();
    }

    public boolean isAlive() {
        return currentHp > 0;
    }
}
