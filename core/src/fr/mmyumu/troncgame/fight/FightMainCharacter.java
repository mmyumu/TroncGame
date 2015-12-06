package fr.mmyumu.troncgame.fight;

import com.badlogic.gdx.assets.AssetManager;

import javax.inject.Inject;

/**
 * The main character during the Fights
 * Created by mmyumu on 30/11/2015.
 */
public class FightMainCharacter extends FightCharacter {

    @Inject
    public FightMainCharacter(AssetManager assetManager) {
        super(100, 500, assetManager);
    }

    @Override
    protected String getTexturePath() {
        return FightConstants.TexturePath.MAIN_CHARACTER;
    }
}
