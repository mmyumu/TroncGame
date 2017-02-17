package fr.mmyumu.troncgame.model;

/**
 *
 * Created by mmyumu on 04/03/2016.
 */
public class Weapon {
    private final WeaponDef definition;

    public Weapon(WeaponDef definition) {
        this.definition = definition;
    }

    public WeaponDef getDefinition() {
        return definition;
    }
}
