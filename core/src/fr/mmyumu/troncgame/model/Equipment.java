package fr.mmyumu.troncgame.model;

/**
 * The equipment of a character
 * Created by mmyumu on 14/02/2016.
 */
public class Equipment {
    private Weapon weapon;

    public void equip(Weapon weapon) {
        this.weapon = weapon;
    }

    public Weapon getWeapon() {
        return weapon;
    }
}
