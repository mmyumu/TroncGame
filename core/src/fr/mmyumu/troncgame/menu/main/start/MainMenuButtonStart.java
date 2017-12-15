package fr.mmyumu.troncgame.menu.main.start;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.utils.I18NBundle;

import javax.inject.Inject;

import fr.mmyumu.troncgame.TroncGame;
import fr.mmyumu.troncgame.menu.main.MainMenuButton;
import fr.mmyumu.troncgame.menu.main.MainMenuButtonLogic;
import fr.mmyumu.troncgame.model.manager.ModelManager;
import fr.mmyumu.troncgame.persistence.GameStatePersister;

/**
 * Actor to display main menu
 * Created by mmyumu on 27/10/2015.
 */
public class MainMenuButtonStart extends MainMenuButton {
    private static final String TAG = "MainMenuButtonStart";

    private final TroncGame troncGame;
    private final GameStatePersister gameStatePersister;
    private final ModelManager modelManager;

    @Inject
    public MainMenuButtonStart(TroncGame troncGame, AssetManager assetManager, I18NBundle bundle, GameStatePersister gameStatePersister, ModelManager modelManager, Integer y) {
        super(assetManager, bundle, y);

        this.troncGame = troncGame;
        this.gameStatePersister = gameStatePersister;
        this.modelManager = modelManager;
    }

    @Override
    protected MainMenuButtonLogic initMenuButtonLogic() {
        return new MainMenuButtonStartLogic(gameStatePersister, troncGame, modelManager);
    }

    @Override
    protected String getPropertyKey() {
        return "start";
    }
}
