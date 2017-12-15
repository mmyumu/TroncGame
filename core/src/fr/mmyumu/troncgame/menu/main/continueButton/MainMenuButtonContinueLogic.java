package fr.mmyumu.troncgame.menu.main.continueButton;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

import fr.mmyumu.troncgame.TroncGame;
import fr.mmyumu.troncgame.menu.main.MainMenuButtonLogic;
import fr.mmyumu.troncgame.persistence.GameStatePersister;
import fr.mmyumu.troncgame.persistence.ScreenID;

/**
 * Created by mmyumu on 15/12/2017.
 */

public class MainMenuButtonContinueLogic extends MainMenuButtonLogic {
    private static final String TAG = "MainMenuButtonContinueLogic";

    public MainMenuButtonContinueLogic(GameStatePersister gameStatePersister, TroncGame troncGame) {
        super(gameStatePersister, troncGame);
    }

    @Override
    public void buttonClicked() {
        Gdx.app.debug(TAG, "Continue button pressed");

        getGameStatePersister().loadModel();

        Screen screen = loadScreen();
        getTroncGame().setScreen(screen);
    }

    private Screen loadScreen() {
        ScreenID screenID = getGameStatePersister().loadScreen();
        Screen screen;
        switch (screenID) {
            case OVERWORLD:
                screen = getTroncGame().getOverworldComponent().createOverworldLoadingScreen();
                break;
            case FIGHT:
                screen = getTroncGame().getFightComponent().createFightLoadingScreen();
                break;

            default:
                screen = getTroncGame().getMainMenuComponent().createMainMenuLoadingScreen();
        }
        return screen;
    }
}
