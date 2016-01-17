package fr.mmyumu.troncgame.model;

/**
 * Manage a character of the game
 * Created by mmyumu on 01/01/2016.
 */
public class GameCharacter {
    private String name;
    private int hp;
    private int mp;
    private double actionSpeed;
    private int attack;

    private String fightTexturePath;

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

    public void attack(GameCharacter character) {
        character.setHp(character.getHp() - attack);
    }

    public boolean isAlive() {
        return hp > 0;
    }
}