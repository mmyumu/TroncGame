package fr.mmyumu.troncgame.overworld;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.GridPoint2;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Character which is displayed on the Overworld map
 * Created by mmyumu on 30/10/2015.
 */
class OverworldCharacter extends Actor {
    private static final int MOVE_SPEED = 20;

    private final AssetManager assetManager;
    private GridPoint2 center;
    private GridPoint2 moveTarget;
    private Rectangle hitBox;
    private Speed speed;

    public OverworldCharacter(GridPoint2 center, AssetManager assetManager) {
        this.center = center;
        this.assetManager = assetManager;

        this.moveTarget = null;
        initHitBoxes(center);
    }

    private void initHitBoxes(GridPoint2 p) {
        hitBox = new Rectangle(retrieveLeft(p), retrieveBottom(p), OverworldConstants.TILE_WIDTH, OverworldConstants.TILE_HEIGHT);
    }

    private int retrieveLeft(GridPoint2 p) {
        return p.x - OverworldConstants.TILE_WIDTH / 2;
    }

    private int retrieveTop(GridPoint2 p) {
        return p.y + OverworldConstants.TILE_HEIGHT / 2;
    }

    private int retrieveRight(GridPoint2 p) {
        return p.x + OverworldConstants.TILE_WIDTH / 2;
    }

    private int retrieveBottom(GridPoint2 p) {
        return p.y - OverworldConstants.TILE_HEIGHT / 2;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        Texture texture = assetManager.get(OverworldConstants.TexturePath.MAIN_CHARACTER, Texture.class);
        batch.draw(texture, retrieveLeft(center), retrieveBottom(center), OverworldConstants.TILE_WIDTH, OverworldConstants.TILE_HEIGHT);
    }
}
