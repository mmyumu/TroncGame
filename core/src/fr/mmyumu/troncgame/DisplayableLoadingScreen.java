package fr.mmyumu.troncgame;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.ScalingViewport;

/**
 * A generic loading screen that can be displayed
 * Created by mmyumu on 01/03/2016.
 */
public abstract class DisplayableLoadingScreen extends LoadingScreen {
    private final SpriteBatch batch;
    private final Texture texture;
    private final ScalingViewport viewport;

    public DisplayableLoadingScreen(TroncGame troncGame, AssetManager assetManager) {
        super(troncGame, assetManager);

        this.batch = new SpriteBatch();
        this.texture = assetManager.get(Constants.TexturePath.LOADING, Texture.class);

        OrthographicCamera camera = new OrthographicCamera();
        camera.setToOrtho(false);
        viewport = new ScalingViewport(Scaling.fit, Constants.WIDTH, Constants.HEIGHT, camera);
        viewport.apply();
        viewport.getCamera().position.set(viewport.getCamera().viewportWidth / 2f, viewport.getCamera().viewportHeight / 2, 0f);
    }

    @Override
    protected void draw() {
        super.draw();
        viewport.getCamera().update();
        batch.setProjectionMatrix(viewport.getCamera().combined);
        batch.begin();
        batch.draw(texture, 0, 0);
        batch.end();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
    }
}
