package fr.mmyumu.troncgame.fight;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScalingViewport;

import java.util.List;

import javax.inject.Inject;

import fr.mmyumu.troncgame.fight.enemy.EnemyFightTeamGenerator;

/**
 * Stage to display the game elements of the Fight
 * Created by mmyumu on 30/11/2015.
 */
public class FightGame extends Stage {
    private final List<FightCharacter> enemyFightTeam;

    @Inject
    public FightGame(ScalingViewport viewport, FightBackground fightBackground, List<FightCharacter> fightTeam, EnemyFightTeamGenerator enemyFightTeamGenerator) {
        super(viewport);

        addActor(fightBackground);
        for (FightCharacter fightCharacter : fightTeam) {
            addActor(fightCharacter);
        }

        enemyFightTeam = enemyFightTeamGenerator.generate();
        for(FightCharacter enemyCharacter : enemyFightTeam) {
            addActor(enemyCharacter);
        }
    }

    public boolean isEnded() {
        for (FightCharacter enemy : enemyFightTeam) {
            if(enemy.getCharacter().isAlive()) {
                return false;
            }
        }
        return true;
    }
}
