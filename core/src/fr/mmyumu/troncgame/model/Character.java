package fr.mmyumu.troncgame.model;

/**
 * Manage a character of the game
 * Created by mmyumu on 01/01/2016.
 */
public class Character {
    private String name;
    private Integer hp;
    private Integer mp;

    public void setName(String name) {
        this.name = name;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    public String getName() {
        return name;
    }

    public Integer getHp() {
        return hp;
    }

    public Integer getMp() {
        return mp;
    }
}
