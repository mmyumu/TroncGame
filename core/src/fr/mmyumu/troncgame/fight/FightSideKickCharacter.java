package fr.mmyumu.troncgame.fight;

import com.badlogic.gdx.assets.AssetManager;

/**
 * The sidekick character during the Fights
 * Created by mmyumu on 04/12/2015.
 */
public class FightSideKickCharacter extends FightCharacter {
    public FightSideKickCharacter(AssetManager assetManager) {
        super(100, 300, assetManager);
    }

    @Override
    protected String getTexturePath() {
        return FightConstants.TexturePath.SIDEKICK_CHARACTER;
    }
}
