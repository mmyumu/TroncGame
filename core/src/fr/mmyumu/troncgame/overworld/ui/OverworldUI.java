package fr.mmyumu.troncgame.overworld.ui;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScalingViewport;

import javax.inject.Inject;
import javax.inject.Named;

import fr.mmyumu.troncgame.TroncGame;

/**
 * Manage the UI of the Overworld
 * Created by mmyumu on 15/11/2015.
 */
public class OverworldUI extends Stage {

    @Inject
    public OverworldUI(ScalingViewport viewport, TroncGame troncGame, @Named("ui") OverworldFPS overworldFPS) {
        super(viewport);
        addActor(overworldFPS);
    }
}
