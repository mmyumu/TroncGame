package fr.mmyumu.troncgame.fight;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;

import fr.mmyumu.troncgame.Constants;

/**
 * Stage to display the game elements of the Fight
 * Created by mmyumu on 30/11/2015.
 */
public class FightGameStage extends Stage {
    public FightGameStage() {
        super(new FitViewport(Constants.WIDTH, Constants.HEIGHT));
    }
}
