package fr.mmyumu.troncgame.overworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;

import javax.inject.Inject;

import fr.mmyumu.troncgame.TroncGame;

/**
 * Created by mmyumu on 28/10/2015.
 */
public class OverworldLoadingScreen extends ScreenAdapter {
    private static final String TAG = "OverworldLoadingScreen";

    private final TroncGame troncGame;
    private final AssetManager assetManager;

    @Inject
    public OverworldLoadingScreen(TroncGame troncGame, AssetManager assetManager) {
        this.troncGame = troncGame;
        this.assetManager = assetManager;
    }

    @Override
    public void show() {
        Gdx.app.debug(TAG, "Loading overworld");
    }

    @Override
    public void render(float delta) {
        if (assetManager.update()) {
            troncGame.setScreen(troncGame.getScreenComponent().createOverworldScreen());
        }
        Gdx.app.debug(TAG, ".");
    }
}
