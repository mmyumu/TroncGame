package fr.mmyumu.troncgame.fight;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScalingViewport;

import javax.inject.Inject;
import javax.inject.Named;


/**
 * Stage to display the actors of the pop-up menu
 * Created by mmyumu on 08/12/2015.
 */
public class FightPopUpMenu extends Stage {
    private FightCharacter fightCharacter;

    @Inject
    public FightPopUpMenu(ScalingViewport viewport, @Named("spells") FightPopUpMenuIcon fightPopUpMenuSpellsIcon, @Named("weapons") FightPopUpMenuIcon fightPopUpMenuWeaponsIcon) {
        super(viewport);

        addActor(fightPopUpMenuSpellsIcon);
        addActor(fightPopUpMenuWeaponsIcon);
    }

    @Override
    public void draw() {
        super.draw();
    }

    public void characterTouched(FightCharacter touchedCharacter, Vector2 touchCoords) {
        if (fightCharacter == touchedCharacter) {
            for (Actor actor : getActors()) {
                if (actor instanceof FightPopUpMenuIcon) {
                    FightPopUpMenuIcon fightPopUpMenuIcon = (FightPopUpMenuIcon) actor;
                    fightCharacter = null;
                    fightPopUpMenuIcon.hide();
                }
            }
        } else {
            for (Actor actor : getActors()) {
                if (actor instanceof FightPopUpMenuIcon) {
                    FightPopUpMenuIcon fightPopUpMenuIcon = (FightPopUpMenuIcon) actor;
                    fightCharacter = touchedCharacter;
                    fightPopUpMenuIcon.display(touchCoords);
                }
            }
        }
    }
}
