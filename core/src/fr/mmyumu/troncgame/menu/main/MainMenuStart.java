package fr.mmyumu.troncgame.menu.main;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.utils.I18NBundle;

import javax.inject.Inject;

import fr.mmyumu.troncgame.TroncGame;
import fr.mmyumu.troncgame.model.manager.ModelManager;
import fr.mmyumu.troncgame.persistence.GameStatePersister;

/**
 * Actor to display main menu
 * Created by mmyumu on 27/10/2015.
 */
public class MainMenuStart extends MainMenuButton {
    private static final String TAG = "MainMenuStart";

    private final TroncGame troncGame;
    private final GameStatePersister gameStatePersister;
    private ModelManager modelManager;

    @Inject
    public MainMenuStart(TroncGame troncGame, AssetManager assetManager, I18NBundle bundle, GameStatePersister gameStatePersister, ModelManager modelManager, Integer y) {
        super(assetManager, bundle, y);

        this.troncGame = troncGame;
        this.gameStatePersister = gameStatePersister;
        this.modelManager = modelManager;
    }

    @Override
    protected void buttonClicked(InputEvent event, float x, float y) {
        Gdx.app.debug(TAG, "Start button pressed");

        gameStatePersister.clear();

        modelManager.newGame();

        troncGame.setScreen(troncGame.getIntroductionComponent().introductionLoadingScreen());
    }

    @Override
    protected String getPropertyKey() {
        return "start";
    }
}
