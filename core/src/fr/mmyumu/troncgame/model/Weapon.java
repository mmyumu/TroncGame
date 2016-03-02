package fr.mmyumu.troncgame.model;

/**
 * Weapon which can be used by a character
 * Created by mmyumu on 14/02/2016.
 */
public class Weapon extends Item {
    private int attack;

    public Weapon(String identifier, String name, String texturePath, int attack) {
        super(identifier, name, texturePath);
        this.attack = attack;
    }

    public int getAttack() {
        return attack;
    }
}
