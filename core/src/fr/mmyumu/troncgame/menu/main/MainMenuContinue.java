package fr.mmyumu.troncgame.menu.main;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.utils.I18NBundle;

import javax.inject.Inject;

import fr.mmyumu.troncgame.TroncGame;

/**
 * Display the Continue button to load the game
 * Created by mmyumu on 31/01/2016.
 */
public class MainMenuContinue extends MainMenuButton {
    private static final String TAG = "MainMenuContinue";

    @Inject
    public MainMenuContinue(TroncGame troncGame, AssetManager assetManager, I18NBundle bundle, int y) {
        super(assetManager, bundle, y);
    }

    @Override
    protected void buttonClicked(InputEvent event, float x, float y) {
        Gdx.app.debug(TAG, "Continue button pressed");
    }

    @Override
    protected String getPropertyKey() {
        return "continue";
    }
}
