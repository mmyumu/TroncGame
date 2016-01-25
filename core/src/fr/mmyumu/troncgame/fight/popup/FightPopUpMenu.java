package fr.mmyumu.troncgame.fight.popup;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScalingViewport;

import java.util.List;

import javax.inject.Inject;


/**
 * Stage to display the actors of the pop-up menu
 * Created by mmyumu on 08/12/2015.
 */
public class FightPopUpMenu extends Stage {
    @Inject
    public FightPopUpMenu(ScalingViewport viewport) {
        super(viewport);
    }

    public void initPopUpElements(List<FightPopUpMenuElement> elements) {
        for (FightPopUpMenuElement popUpMenuElement : elements) {
            addActor(popUpMenuElement);
        }
    }
}
