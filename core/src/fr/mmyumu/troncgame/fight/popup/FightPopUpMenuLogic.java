package fr.mmyumu.troncgame.fight.popup;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import fr.mmyumu.troncgame.fight.FightCharacter;
import fr.mmyumu.troncgame.model.ModelConstants;
import fr.mmyumu.troncgame.model.Weapon;

/**
 * Manage the logic of the pop up menu
 * Created by mmyumu on 22/01/2016.
 */
public class FightPopUpMenuLogic {
    private final AssetManager assetManager;
    private final List<FightPopUpMenuIcon> popMenuIcons;
    private final FightPopUpMenuIcon fightPopUpMenuWeaponsIcon;
    private final FightPopUpMenuNotReady popUpMenuNotReady;

    @Inject
    public FightPopUpMenuLogic(AssetManager assetManager, FightPopUpMenuNotReady fightPopUpMenuNotReady, @Named("spells") FightPopUpMenuIcon fightPopUpMenuSpellsIcon, @Named("weapons") FightPopUpMenuIcon fightPopUpMenuWeaponsIcon) {
        this.assetManager = assetManager;
        this.popUpMenuNotReady = fightPopUpMenuNotReady;

        this.fightPopUpMenuWeaponsIcon = fightPopUpMenuWeaponsIcon;

        popMenuIcons = new ArrayList<FightPopUpMenuIcon>();
        popMenuIcons.add(fightPopUpMenuSpellsIcon);
        popMenuIcons.add(fightPopUpMenuWeaponsIcon);
    }

    public List<FightPopUpMenuElement> getPopUpMenuElements() {
        List<FightPopUpMenuElement> actors = new ArrayList<FightPopUpMenuElement>();
        for (FightPopUpMenuIcon popUpMenuIcon : popMenuIcons) {
            actors.add(popUpMenuIcon);
        }

        actors.add(popUpMenuNotReady);
        return actors;
    }

    public void selectNotReadyCharacter(FightCharacter selected) {
        popUpMenuNotReady.display(selected.getCenter());
    }

    public void selectReadyCharacter(FightCharacter selectedCharacter) {
        for (FightPopUpMenuIcon fightPopUpMenuIcon : popMenuIcons) {
            fightPopUpMenuIcon.select();
            fightPopUpMenuIcon.display(selectedCharacter.getCenter());
        }
    }

    public void selectIcon(FightPopUpMenuIcon selectedIcon) {
        for (FightPopUpMenuIcon popUpMenuIcon : popMenuIcons) {
            if (popUpMenuIcon.equals(selectedIcon)) {
                popUpMenuIcon.select();
            } else {
                popUpMenuIcon.unselect();
            }
        }
    }

    public void unselectCharacter() {
        for (FightPopUpMenuIcon fightPopUpMenuIcon : popMenuIcons) {
            fightPopUpMenuIcon.hide();
        }
    }

    public void selectCharacter(FightCharacter selectedCharacter) {
        Weapon weapon = selectedCharacter.getCharacter().getEquipment().getWeapon();

        Texture texture;
        if (weapon != null) {
            texture = assetManager.get(selectedCharacter.getCharacter().getEquipment().getWeapon().getDefinition().getTexturePath(), Texture.class);
        } else {
            texture = assetManager.get(ModelConstants.TexturePath.FIST, Texture.class);
        }

        fightPopUpMenuWeaponsIcon.setTexture(texture);
    }
}
