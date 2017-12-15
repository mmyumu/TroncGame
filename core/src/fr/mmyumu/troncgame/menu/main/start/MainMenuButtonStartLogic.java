package fr.mmyumu.troncgame.menu.main.start;

import com.badlogic.gdx.Gdx;

import fr.mmyumu.troncgame.TroncGame;
import fr.mmyumu.troncgame.menu.main.MainMenuButtonLogic;
import fr.mmyumu.troncgame.model.manager.ModelManager;
import fr.mmyumu.troncgame.persistence.GameStatePersister;

/**
 * Created by mmyumu on 15/12/2017.
 */

class MainMenuButtonStartLogic extends MainMenuButtonLogic {
    private static final String TAG = "MainMenuButtonStartLogic";
    private ModelManager modelManager;

    public MainMenuButtonStartLogic(GameStatePersister gameStatePersister, TroncGame troncGame, ModelManager modelManager) {
        super(gameStatePersister, troncGame);
        this.modelManager = modelManager;
    }

    @Override
    public void buttonClicked() {
        Gdx.app.debug(TAG, "Start button pressed");

        getGameStatePersister().clear();

        modelManager.newGame();

        getTroncGame().setScreen(getTroncGame().getIntroductionComponent().introductionLoadingScreen());
    }
}
