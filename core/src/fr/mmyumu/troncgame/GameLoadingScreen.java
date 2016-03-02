package fr.mmyumu.troncgame;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;

import javax.inject.Inject;

/**
 * General loading screen (first screen displayed)
 * Created by mmyumu on 01/03/2016.
 */
public class GameLoadingScreen extends LoadingScreen {

    @Inject
    public GameLoadingScreen(TroncGame troncGame, AssetManager assetManager) {
        super(troncGame, assetManager);
    }

    @Override
    protected Screen getNextScreen() {
        return troncGame.getMainMenuComponent().createMainMenuLoadingScreen();
    }

    @Override
    protected void load() {
        assetManager.load(Constants.TexturePath.LOADING, Texture.class);
    }

    @Override
    protected String getDebugName() {
        return "game";
    }
}
