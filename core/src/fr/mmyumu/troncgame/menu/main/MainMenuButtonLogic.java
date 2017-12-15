package fr.mmyumu.troncgame.menu.main;

import fr.mmyumu.troncgame.TroncGame;
import fr.mmyumu.troncgame.persistence.GameStatePersister;

/**
 * Created by mmyumu on 15/12/2017.
 */

public abstract class MainMenuButtonLogic {
    private GameStatePersister gameStatePersister;
    private TroncGame troncGame;

    public MainMenuButtonLogic(GameStatePersister gameStatePersister, TroncGame troncGame) {
        this.gameStatePersister = gameStatePersister;
        this.troncGame = troncGame;
    }

    public abstract void buttonClicked();

    public GameStatePersister getGameStatePersister() {
        return gameStatePersister;
    }

    public TroncGame getTroncGame() {
        return troncGame;
    }
}
