package fr.mmyumu.troncgame.overworld.ui;

import com.badlogic.gdx.scenes.scene2d.Stage;

import javax.inject.Inject;

import fr.mmyumu.troncgame.TroncGame;

/**
 * Manage the UI of the Overworld
 * Created by mmyumu on 15/11/2015.
 */
public class OverworldUIStage extends Stage {

    @Inject
    public OverworldUIStage(TroncGame troncGame) {
        OverworldFPSActor overworldFPSActor = troncGame.getOverworldComponent().createOverworldFPSActor();
        addActor(overworldFPSActor);
    }
}
