package fr.mmyumu.troncgame.menu.main.continueButton;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.utils.I18NBundle;

import javax.inject.Inject;

import fr.mmyumu.troncgame.TroncGame;
import fr.mmyumu.troncgame.menu.main.MainMenuButton;
import fr.mmyumu.troncgame.menu.main.MainMenuButtonLogic;
import fr.mmyumu.troncgame.persistence.GameStatePersister;

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
    protected MainMenuButtonLogic initMenuButtonLogic() {
        return new MainMenuButtonContinueLogic(gameStatePersister, troncGame);
    }

    @Override
    protected String getPropertyKey() {
        return "continue";
    }
}
