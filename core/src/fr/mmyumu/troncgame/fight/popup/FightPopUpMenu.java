package fr.mmyumu.troncgame.fight.popup;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScalingViewport;

import java.util.List;


/**
 * Stage to display the actors of the pop-up menu
 * Created by mmyumu on 08/12/2015.
 */
public class FightPopUpMenu extends Stage {
    public FightPopUpMenu(ScalingViewport viewport) {
        super(viewport);
    }

    public void initPopUpElements(List<FightPopUpMenuElement> elements) {
        for (FightPopUpMenuElement popUpMenuElement : elements) {
            addActor(popUpMenuElement);
        }
    }
}
