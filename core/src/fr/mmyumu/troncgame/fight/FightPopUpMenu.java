package fr.mmyumu.troncgame.fight;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScalingViewport;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;


/**
 * Stage to display the actors of the pop-up menu
 * Created by mmyumu on 08/12/2015.
 */
public class FightPopUpMenu extends Stage {
    private FightCharacter selectedCharacter;
    private FightPopUpMenuIcon selectedIcon;
    private List<FightPopUpMenuIcon> fightPopMenuIcons;

    private FightPopUpMenuNotReady fightPopUpMenuNotReady;

    @Inject
    public FightPopUpMenu(ScalingViewport viewport, FightPopUpMenuNotReady fightPopUpMenuNotReady, @Named("spells") FightPopUpMenuIcon fightPopUpMenuSpellsIcon, @Named("weapons") FightPopUpMenuIcon fightPopUpMenuWeaponsIcon) {
        super(viewport);

        fightPopMenuIcons = new ArrayList<FightPopUpMenuIcon>();
        fightPopMenuIcons.add(fightPopUpMenuSpellsIcon);
        fightPopMenuIcons.add(fightPopUpMenuWeaponsIcon);

        this.fightPopUpMenuNotReady = fightPopUpMenuNotReady;

        addActors();
    }

    private void addActors() {
        for (FightPopUpMenuIcon fightPopUpMenuIcon : fightPopMenuIcons) {
            addActor(fightPopUpMenuIcon);
        }
        addActor(fightPopUpMenuNotReady);
    }

    public boolean characterTouched(FightCharacter touchedCharacter, Vector2 touchCoords) {
        if (touchedCharacter.hasFightPopUpMenu()) {
            if (selectedCharacter == touchedCharacter) {
                retouchCharacter();
            } else {
                touchCharacter(touchedCharacter, touchCoords);
            }
        }

        return selectedCharacter != null;
    }

    private boolean hasActionSelected() {
        return selectedIcon != null && selectedIcon.isAction();
    }

    private void retouchCharacter() {
        for (FightPopUpMenuIcon fightPopUpMenuIcon : fightPopMenuIcons) {
            selectedCharacter = null;
            fightPopUpMenuIcon.hide();
        }
    }

    private void touchCharacter(FightCharacter touchedCharacter, Vector2 touchCoords) {
        if (touchedCharacter.isReady()) {
            displayMenu(touchedCharacter, touchCoords);
        } else {
            displayNotReady(touchCoords);
        }
    }

    private void displayNotReady(Vector2 touchCoords) {
        selectedCharacter = null;
        fightPopUpMenuNotReady.display(touchCoords);

        hideIcons();
    }

    private void hideIcons() {
        for (FightPopUpMenuIcon fightPopUpMenuIcon : fightPopMenuIcons) {
            fightPopUpMenuIcon.hide();
        }
    }

    private void displayMenu(FightCharacter touchedCharacter, Vector2 touchCoords) {
        selectedCharacter = touchedCharacter;
        selectedIcon = null;
        fightPopUpMenuNotReady.hide();

        for (FightPopUpMenuIcon fightPopUpMenuIcon : fightPopMenuIcons) {
            fightPopUpMenuIcon.display(touchCoords);
        }
    }

    public boolean iconTouched(FightPopUpMenuIcon fightPopUpMenuIcon, Vector2 touchCoords) {
        if (selectedIcon == fightPopUpMenuIcon) {
            retouchIcon();
        } else {
            touchIcon(fightPopUpMenuIcon, touchCoords);
        }

        return hasActionSelected();
    }

    private void retouchIcon() {
        selectedCharacter = null;
    }

    private void touchIcon(FightPopUpMenuIcon touchedIcon, Vector2 touchCoords) {
        selectedIcon = touchedIcon;

        for (FightPopUpMenuIcon fightPopUpMenuIcon : fightPopMenuIcons) {
            fightPopUpMenuIcon.unselect();
        }

        selectedIcon.select();
    }

    public FightCharacter getSelectedCharacter() {
        return selectedCharacter;
    }

    public void reset() {
        selectedCharacter = null;
        selectedIcon = null;

        hideIcons();
    }
}
