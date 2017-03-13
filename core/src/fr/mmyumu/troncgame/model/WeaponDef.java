package fr.mmyumu.troncgame.model;

/**
 * Definition of weapon which can be used by a character
 * Created by mmyumu on 14/02/2016.
 */
public class WeaponDef extends ItemDef {
    private final int attack;

    public WeaponDef(String identifier, String name, String texturePath, int attack) {
        super(identifier, name, texturePath);
        this.attack = attack;
    }

    public int getAttack() {
        return attack;
    }
}
