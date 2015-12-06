package fr.mmyumu.troncgame.fight;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.badlogic.gdx.utils.Pool;

/**
 * Generic behaviors of characters in a Fight
 * Created by mmyumu on 04/12/2015.
 */
public abstract class FightCharacter extends Actor {
    private AssetManager assetManager;

    public FightCharacter(int x, int y, AssetManager assetManager) {
        this.assetManager = assetManager;

        setPosition(x, y);
    }


    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(assetManager.get(getTexturePath(), Texture.class), getX(), getY(), FightConstants.CHARACTER_WIDTH, FightConstants.CHARACTER_HEIGHT);
    }

    protected abstract String getTexturePath();
}
