package fr.mmyumu.troncgame.fight.enemy;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import fr.mmyumu.troncgame.fight.FightCharacter;
import fr.mmyumu.troncgame.fight.FightConstants;
import fr.mmyumu.troncgame.model.GameCharacter;
import fr.mmyumu.troncgame.model.manager.CharacterManager;

/**
 * Generate an enemy team from the location of the character
 * Created by mmyumu on 16/01/2016.
 */
public class EnemyFightTeamGenerator {
    private final AssetManager assetManager;
    private final CharacterManager characterManager;
    private final Skin skin;

    @Inject
    public EnemyFightTeamGenerator(AssetManager assetManager, CharacterManager characterManager, Skin skin) {
        this.assetManager = assetManager;
        this.characterManager = characterManager;
        this.skin = skin;
    }

    public List<FightCharacter> generate() {
        List<FightCharacter> enemyFightTeam = new ArrayList<FightCharacter>();

        // TODO: generate according to the location of the game character

        GameCharacter enemy1 = new GameCharacter(characterManager.getCharacters().get("soldier"));
        enemy1.setName("Soldier 1");
        GameCharacter enemy2 = new GameCharacter(characterManager.getCharacters().get("soldier"));
        enemy1.setName("Soldier 2");

        enemyFightTeam.add(new FightCharacter(skin, 1500, FightConstants.MAIN_INFOS_HEIGHT + 20 + 200, enemy1, assetManager.get(enemy1.getDefinition().getFightWaitingTexturePath(), Texture.class), false));
        enemyFightTeam.add(new FightCharacter(skin, 1500, FightConstants.MAIN_INFOS_HEIGHT + 20 + 200 * 2, enemy2, assetManager.get(enemy2.getDefinition().getFightWaitingTexturePath(), Texture.class), false));

        return enemyFightTeam;
    }
}
