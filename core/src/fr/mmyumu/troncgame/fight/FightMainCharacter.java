package fr.mmyumu.troncgame.fight;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

import javax.inject.Inject;

/**
 * The main character during the fights
 * Created by mmyumu on 30/11/2015.
 */
public class FightMainCharacter extends Actor {

    private AssetManager assetManager;

    @Inject
    public FightMainCharacter(AssetManager assetManager) {
        this.assetManager = assetManager;
    }


    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(assetManager.get(FightConstants.TexturePath.MAIN_CHARACTER, Texture.class), 0, 0, FightConstants.CHARACTER_WIDTH, FightConstants.CHARACTER_HEIGHT);
    }
}
