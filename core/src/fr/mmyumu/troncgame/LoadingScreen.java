package fr.mmyumu.troncgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;

/**
 * Loading generic screen
 * Created by mmyumu on 01/03/2016.
 */
public abstract class LoadingScreen extends ScreenAdapter {
    private static final String TAG = "LoadingScreen";

    protected final TroncGame troncGame;
    protected final AssetManager assetManager;

    public LoadingScreen(TroncGame troncGame, AssetManager assetManager) {
        this.troncGame = troncGame;
        this.assetManager = assetManager;
    }

    @Override
    public void show() {
        Gdx.app.debug(TAG, "Loading " + getDebugName());

        load();
    }

    @Override
    public void render(float delta) {
        Gdx.app.debug(TAG, "Progress " + assetManager.getProgress());
        if (assetManager.update()) {
            troncGame.setScreen(getNextScreen());
        }
        draw();
    }

    protected void draw() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    protected abstract Screen getNextScreen();

    protected abstract void load();

    protected abstract String getDebugName();
}
