package fr.mmyumu.troncgame.model;

import com.badlogic.gdx.Gdx;

/**
 * Manage a character of the game
 * Created by mmyumu on 01/01/2016.
 */
public class GameCharacter {
    private static final String TAG = "GameCharacter";
    private String identifier;
    private String name;
    private int hp;
    private int mp;
    private double actionSpeed;
    private int attack;
    private boolean friendly;

    private String fightTexturePath;
    private boolean usingAI;

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    public double getActionSpeed() {
        return actionSpeed;
    }

    public void setActionSpeed(double actionSpeed) {
        this.actionSpeed = actionSpeed;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public String getFightTexturePath() {
        return fightTexturePath;
    }

    public void setFightTexturePath(String fightTexturePath) {
        this.fightTexturePath = fightTexturePath;
    }

    public int attack(GameCharacter character) {
        character.setHp(character.getHp() - attack);
        Gdx.app.debug(TAG, getName() + " is attacking " + character.getName() + " for " + attack + " damage. " + character.getHp() + "HP left.");
        return attack;
    }

    public boolean isAlive() {
        return hp > 0;
    }

    public boolean isFriendly() {
        return friendly;
    }

    public void setFriendly(boolean friendly) {
        this.friendly = friendly;
    }

    public boolean isUsingAI() {
        return usingAI;
    }

    public void setUsingAI(boolean usingAI) {
        this.usingAI = usingAI;
    }
}
