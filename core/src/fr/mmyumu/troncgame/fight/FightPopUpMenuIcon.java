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

    private final Texture texture;

    private final boolean action;

    private float alpha;


    public FightPopUpMenuIcon(String texturePath, CompassPoint compassPoint, AssetManager assetManager, boolean action) {
        super(compassPoint);
        this.texture = assetManager.get(texturePath, Texture.class);
        this.action = action;
        alpha = 1f;
        setName(texturePath);
    }

    @Override
    protected void drawElement(Batch batch, float parentAlpha) {
        batch.setColor(1f, 1f, 1f, alpha * parentAlpha);
        batch.draw(texture, getX(), getY(), getWidth(), getHeight());
    }

    @Override
    protected float getRadius() {
        return RADIUS;
    }

    @Override
    public void hide() {
        super.hide();
        alpha = 1f;
    }

    public void select() {
        alpha = 1f;
    }

    public void unselect() {
        alpha = 0.5f;
    }

    public boolean isAction() {
        return action;
    }
}
