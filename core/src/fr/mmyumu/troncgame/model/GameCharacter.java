package fr.mmyumu.troncgame.model;

/**
 * Manage a character of the game
 * Created by mmyumu on 01/01/2016.
 */
public class GameCharacter {
    private String name;
    private Integer hp;
    private Integer mp;
    private double actionSpeed;

    private String fightTexturePath;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHp() {
        return hp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

    public Integer getMp() {
        return mp;
    }

    public void setMp(Integer mp) {
        this.mp = mp;
    }

    public double getActionSpeed() {
        return actionSpeed;
    }

    public void setActionSpeed(double actionSpeed) {
        this.actionSpeed = actionSpeed;
    }

    public String getFightTexturePath() {
        return fightTexturePath;
    }

    public void setFightTexturePath(String fightTexturePath) {
        this.fightTexturePath = fightTexturePath;
    }
}
