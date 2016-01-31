package fr.mmyumu.troncgame.fight.enemy;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import fr.mmyumu.troncgame.fight.FightCharacter;
import fr.mmyumu.troncgame.fight.FightConstants;
import fr.mmyumu.troncgame.model.GameCharacter;

/**
 * Generate an enemy team from the location of the character
 * Created by mmyumu on 16/01/2016.
 */
public class EnemyFightTeamGenerator {
    private final AssetManager assetManager;
    private final GameCharacter gameCharacter;

    @Inject
    public EnemyFightTeamGenerator(AssetManager assetManager, GameCharacter gameCharacter) {
        this.assetManager = assetManager;
        this.gameCharacter = gameCharacter;
    }

    public List<FightCharacter> generate() {
        List<FightCharacter> enemyFightTeam = new ArrayList<FightCharacter>();

        // TODO: generate according to the location of the game character

        GameCharacter enemy1 = createEnemy();
        GameCharacter enemy2 = createEnemy();

        enemyFightTeam.add(new FightCharacter(1500, FightConstants.MAIN_INFOS_HEIGHT + 20 + 200 * 1, enemy1, assetManager.get(enemy1.getFightTexturePath(), Texture.class), false));
        enemyFightTeam.add(new FightCharacter(1500, FightConstants.MAIN_INFOS_HEIGHT + 20 + 200 * 2, enemy2, assetManager.get(enemy2.getFightTexturePath(), Texture.class), false));

        return enemyFightTeam;
    }

    private GameCharacter createEnemy() {
        GameCharacter enemy = new GameCharacter();
        enemy.setName("Mirror");
        enemy.setHp(20);
        enemy.setMp(5);
        enemy.setActionSpeed(10);
        enemy.setFightTexturePath(FightConstants.TexturePath.ENEMY);
        enemy.setFriendly(false);
        return enemy;
    }
}
