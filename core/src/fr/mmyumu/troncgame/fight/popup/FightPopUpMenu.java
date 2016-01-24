package fr.mmyumu.troncgame.fight.popup;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScalingViewport;

import javax.inject.Inject;


/**
 * Stage to display the actors of the pop-up menu
 * Created by mmyumu on 08/12/2015.
 */
public class FightPopUpMenu extends Stage {
    private final FightPopUpMenuLogic fightPopUpMenuLogic;

    @Inject
    public FightPopUpMenu(ScalingViewport viewport, FightPopUpMenuLogic fightPopUpMenuLogic) {
        super(viewport);
        this.fightPopUpMenuLogic = fightPopUpMenuLogic;
        addActors();
    }

    private void addActors() {
        for (FightPopUpMenuElement popUpMenuElement : fightPopUpMenuLogic.getActors()) {
            addActor(popUpMenuElement);
        }
    }
}
