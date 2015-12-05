package fr.mmyumu.troncgame.fight;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

import javax.inject.Inject;

import fr.mmyumu.troncgame.Constants;

/**
 * The background of the Fight
 * Created by mmyumu on 05/12/2015.
 */
public class FightBackground extends Actor {

    private AssetManager assetManager;

    @Inject
    public FightBackground(AssetManager assetManager) {
        this.assetManager = assetManager;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(assetManager.get(FightConstants.TexturePath.BACKGROUND_PLAIN, Texture.class), 0, 0, Constants.WIDTH, Constants.HEIGHT);
    }
}
