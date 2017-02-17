package fr.mmyumu.troncgame.fight;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

import fr.mmyumu.troncgame.Constants;

/**
 * The background of the Fight
 * Created by mmyumu on 05/12/2015.
 */
public class FightBackground extends Actor {

    private final AssetManager assetManager;
    private boolean darkened;

    public FightBackground(AssetManager assetManager) {
        this.assetManager = assetManager;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        if (darkened) {
            batch.setColor(0.5f, 0.5f, 0.5f, 1f);
        } else {
            batch.setColor(1f, 1f, 1f, 1f);
        }
        batch.draw(assetManager.get(FightConstants.TexturePath.BACKGROUND_PLAIN, Texture.class), 0, 0, Constants.WIDTH, Constants.HEIGHT);
        if (darkened) {
            batch.setColor(1f, 1f, 1f, 1f);
        }
    }

    public void setDarkened(boolean darkened) {
        this.darkened = darkened;
    }
}
