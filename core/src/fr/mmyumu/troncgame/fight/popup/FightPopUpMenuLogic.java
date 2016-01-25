package fr.mmyumu.troncgame.fight.popup;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import fr.mmyumu.troncgame.fight.FightCharacter;


/**
 * Manage the logic of the pop up menu
 * Created by mmyumu on 22/01/2016.
 */
public class FightPopUpMenuLogic {
    private List<FightPopUpMenuIcon> popMenuIcons;
    private FightPopUpMenuNotReady popUpMenuNotReady;

    @Inject
    public FightPopUpMenuLogic(FightPopUpMenuNotReady fightPopUpMenuNotReady, @Named("spells") FightPopUpMenuIcon fightPopUpMenuSpellsIcon, @Named("weapons") FightPopUpMenuIcon fightPopUpMenuWeaponsIcon) {
        this.popUpMenuNotReady = fightPopUpMenuNotReady;

        popMenuIcons = new ArrayList<FightPopUpMenuIcon>();
        popMenuIcons.add(fightPopUpMenuSpellsIcon);
        popMenuIcons.add(fightPopUpMenuWeaponsIcon);
    }

    public List<FightPopUpMenuElement> getActors() {
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
}
