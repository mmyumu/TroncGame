package fr.mmyumu.troncgame.menu.main;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;

import javax.inject.Inject;

import fr.mmyumu.troncgame.TroncGame;

/**
 * Loading screen when the application is started
 * Created by mmyumu on 24/10/2015.
 */
public class MainMenuLoadingScreen extends ScreenAdapter {
    private static final String TAG = "LoadingScreen";

    private final TroncGame troncGame;
    private final AssetManager assetManager;

    @Inject
    public MainMenuLoadingScreen(TroncGame troncGame, AssetManager assetManager) {
        this.troncGame = troncGame;
        this.assetManager = assetManager;
    }

    @Override
    public void show() {
        Gdx.app.debug(TAG, "Loading main menu");
        assetManager.load("data/main_menu.png", Texture.class);
    }

    @Override
    public void render(float delta) {
        if (assetManager.update()) {
            troncGame.setScreen(troncGame.getMainMenuComponent().createMainMenuScreen());
        }
        Gdx.app.debug(TAG, ".");
    }
}
