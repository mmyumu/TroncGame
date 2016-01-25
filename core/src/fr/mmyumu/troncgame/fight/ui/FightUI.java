package fr.mmyumu.troncgame.fight.ui;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScalingViewport;

/**
 * Stage to display the UI of the fight
 * Created by mmyumu on 14/12/2015.
 */
public class FightUI extends Stage {
    public FightUI(ScalingViewport viewport) {
        super(viewport);
    }

    public void initMainInfos(FightMainInfos mainInfos) {
        addActor(mainInfos);
    }
}
