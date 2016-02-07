package fr.mmyumu.troncgame.menu.main;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.utils.I18NBundle;

import javax.inject.Inject;

import fr.mmyumu.troncgame.TroncGame;
import fr.mmyumu.troncgame.persistence.GameStatePersister;
import fr.mmyumu.troncgame.persistence.ScreenID;

/**
 * Display the Continue button to load the game
 * Created by mmyumu on 31/01/2016.
 */
public class MainMenuContinue extends MainMenuButton {
    private static final String TAG = "MainMenuContinue";
    private final TroncGame troncGame;
    private final GameStatePersister gameStatePersister;

    @Inject
    public MainMenuContinue(TroncGame troncGame, AssetManager assetManager, I18NBundle bundle, GameStatePersister gameStatePersister, int y) {
        super(assetManager, bundle, y);
        this.troncGame = troncGame;
        this.gameStatePersister = gameStatePersister;
    }

    @Override
    protected void buttonClicked(InputEvent event, float x, float y) {
        Gdx.app.debug(TAG, "Continue button pressed");

        gameStatePersister.loadModel();

        ScreenID screenID = gameStatePersister.loadScreen();
        Screen screen;
        switch (screenID) {
            case OVERWORLD:
                screen = troncGame.getOverworldComponent().createOverworldLoadingScreen();
                break;
            case FIGHT:
                screen = troncGame.getFightComponent().createFightLoadingScreen();
                break;

            default:
                screen = troncGame.getMainMenuComponent().createMainMenuLoadingScreen();
        }
        troncGame.setScreen(screen);
    }

    @Override
    protected String getPropertyKey() {
        return "continue";
    }
}
