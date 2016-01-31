package fr.mmyumu.troncgame.fight.game;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScalingViewport;

import java.util.List;

import javax.inject.Inject;

import fr.mmyumu.troncgame.fight.FightBackground;
import fr.mmyumu.troncgame.fight.FightCharacter;

/**
 * Stage to display the game elements of the Fight
 * Created by mmyumu on 30/11/2015.
 */
public class FightGame extends Stage {
    @Inject
    public FightGame(ScalingViewport viewport) {
        super(viewport);
    }

    public void initBackground(FightBackground fightBackground) {
        addActor(fightBackground);
    }

    public void initFightTeam(List<FightCharacter> fightTeam) {
        for (FightCharacter fightCharacter : fightTeam) {
            addActor(fightCharacter);
        }
    }

    public void initEnemyTeam(List<FightCharacter> enemyTeam) {
        for (FightCharacter enemyCharacter : enemyTeam) {
            addActor(enemyCharacter);
        }
    }
}
