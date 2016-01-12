package fr.mmyumu.troncgame.fight;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

import fr.mmyumu.troncgame.CompassPoint;

/**
 * Actor for an icon of the Pop-up Menu
 * Created by mmyumu on 08/12/2015.
 */
public class FightPopUpMenuIcon extends FightPopUpMenuElement {
    private static final float RADIUS = 200f;
    
    private final String texturePath;
    private final AssetManager assetManager;


    public FightPopUpMenuIcon(String texturePath, CompassPoint compassPoint, AssetManager assetManager) {
        super(compassPoint);
        this.texturePath = texturePath;
        this.assetManager = assetManager;
    }

    @Override
    protected void drawElement(Batch batch, float parentAlpha) {
        batch.draw(assetManager.get(texturePath, Texture.class), getX(), getY(), getWidth(), getHeight());
    }

    @Override
    protected float getRadius() {
        return RADIUS;
    }


}
