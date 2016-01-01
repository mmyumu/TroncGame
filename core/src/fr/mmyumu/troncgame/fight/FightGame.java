package fr.mmyumu.troncgame.fight;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScalingViewport;

import javax.inject.Inject;

/**
 * Stage to display the game elements of the Fight
 * Created by mmyumu on 30/11/2015.
 */
public class FightGame extends Stage {
    @Inject
    public FightGame(ScalingViewport viewport, FightBackground fightBackground, FightMainCharacter fightMainCharacter, FightSideKickCharacter fightSideKickCharacter) {
        super(viewport);

        addActor(fightBackground);
        addActor(fightMainCharacter);
        addActor(fightSideKickCharacter);
    }
}
