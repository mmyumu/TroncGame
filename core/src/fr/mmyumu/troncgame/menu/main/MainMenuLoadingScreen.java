package fr.mmyumu.troncgame.menu.main;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;

import fr.mmyumu.troncgame.DisplayableLoadingScreen;
import fr.mmyumu.troncgame.TroncGame;
import fr.mmyumu.troncgame.model.ModelConstants;

/**
 * Loading screen when the application is started
 * Created by mmyumu on 24/10/2015.
 */
public class MainMenuLoadingScreen extends DisplayableLoadingScreen {

    public MainMenuLoadingScreen(TroncGame troncGame, AssetManager assetManager) {
        super(troncGame, assetManager);
    }

    @Override
    protected Screen getNextScreen() {
        return troncGame.getMainMenuComponent().createMainMenuScreen();
    }

    @Override
    protected void load() {
        assetManager.load(MainMenuConstants.TexturePath.BACKGROUND, Texture.class);
        loadWeapons();
    }

    private void loadWeapons() {
        assetManager.load(ModelConstants.TexturePath.FIST, Texture.class);
        assetManager.load(ModelConstants.TexturePath.BASIC_SWORD, Texture.class);
    }

    @Override
    protected String getDebugName() {
        return "main menu";
    }
}
