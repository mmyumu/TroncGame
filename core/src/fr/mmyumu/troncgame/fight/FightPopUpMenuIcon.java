package fr.mmyumu.troncgame.fight;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;

import javax.inject.Inject;

import fr.mmyumu.troncgame.CompassPoint;

/**
 * Actor for an icon of the Pop-up Menu
 * Created by mmyumu on 08/12/2015.
 */
public class FightPopUpMenuIcon extends Actor {
    private static final float RADIUS = 200f;

    private final String texturePath;
    private final CompassPoint compassPoint;
    private final AssetManager assetManager;
    private Vector2 menuCenter;

    @Inject
    public FightPopUpMenuIcon(String texturePath, CompassPoint compassPoint, AssetManager assetManager) {
        this.texturePath = texturePath;
        this.compassPoint = compassPoint;
        this.assetManager = assetManager;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        if (menuCenter != null) {
            batch.draw(assetManager.get(texturePath, Texture.class), getX(), getY(), getWidth(), getHeight());
        }
    }

    public void display(Vector2 touchCoords) {
        menuCenter = touchCoords;
        Vector2 iconCoords = computeIconCoords();
        setBounds(iconCoords.x, iconCoords.y, FightConstants.ICON_WIDTH, FightConstants.ICON_HEIGHT);
    }

    public void hide() {
        menuCenter = null;
    }

    private Vector2 computeIconCoords() {
        float x = RADIUS * (float) Math.cos(compassPoint.getRadiansAngle()) + menuCenter.x - FightConstants.ICON_WIDTH / 2;
        float y = RADIUS * (float) Math.sin(compassPoint.getRadiansAngle()) + menuCenter.y - FightConstants.ICON_HEIGHT / 2;

        return new Vector2(x, y);
    }
}
