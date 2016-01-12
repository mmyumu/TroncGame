package fr.mmyumu.troncgame.fight;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScalingViewport;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.fadeOut;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.moveTo;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.run;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.sequence;


/**
 * Stage to display the actors of the pop-up menu
 * Created by mmyumu on 08/12/2015.
 */
public class FightPopUpMenu extends Stage {
    private FightCharacter fightCharacter;
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

    public void characterTouched(FightCharacter touchedCharacter, Vector2 touchCoords) {
        if (fightCharacter == touchedCharacter) {
            retouchCharacter();
        } else {
            touchCharacter(touchedCharacter, touchCoords);
        }
    }

    private void retouchCharacter() {
        for (FightPopUpMenuIcon fightPopUpMenuIcon : fightPopMenuIcons) {
            fightCharacter = null;
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
        fightCharacter = null;
        fightPopUpMenuNotReady.display(touchCoords);

        for (FightPopUpMenuIcon fightPopUpMenuIcon : fightPopMenuIcons) {
            fightPopUpMenuIcon.hide();
        }
    }

    private void displayMenu(FightCharacter touchedCharacter, Vector2 touchCoords) {
        fightCharacter = touchedCharacter;
        fightPopUpMenuNotReady.hide();

        for (FightPopUpMenuIcon fightPopUpMenuIcon : fightPopMenuIcons) {
            fightPopUpMenuIcon.display(touchCoords);
        }
    }
}
