package fr.mmyumu.troncgame.overworld.game;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import javax.inject.Inject;

import fr.mmyumu.troncgame.overworld.OverworldConstants;


/**
 * GameCharacter which is displayed on the Overworld map
 * Created by mmyumu on 30/10/2015.
 */
public class OverworldCharacter extends OverworldCharacterLogic {
    private final SpriteBatch batch;
    private final Camera camera;
    private final AssetManager assetManager;

    @Inject
    public OverworldCharacter(AssetManager assetManager, Camera camera) {
        super();
        this.assetManager = assetManager;
        this.camera = camera;
        this.batch = new SpriteBatch();
    }

    public void draw() {
        batch.begin();
        Texture texture = assetManager.get(OverworldConstants.TexturePath.MAIN_CHARACTER, Texture.class);
        batch.setProjectionMatrix(camera.combined);
        batch.setColor(1, 1, 1, 1);
        batch.draw(texture, getX(), getY(), OverworldConstants.TILE_WIDTH, OverworldConstants.TILE_HEIGHT);
        batch.end();
    }
}
