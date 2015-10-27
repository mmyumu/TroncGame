package fr.mmyumu.troncgame;

import com.badlogic.gdx.Game;

import javax.inject.Singleton;

import fr.mmyumu.troncgame.components.DaggerGameComponent;
import fr.mmyumu.troncgame.components.DaggerScreenComponent;
import fr.mmyumu.troncgame.components.GameComponent;
import fr.mmyumu.troncgame.components.ScreenComponent;
import fr.mmyumu.troncgame.modules.GameModule;
import fr.mmyumu.troncgame.modules.ScreenModule;

@Singleton
public class TroncGame extends Game {

    private GameComponent gameComponent;
    private ScreenComponent screenComponent;

    public TroncGame() {
    }

    @Override
    public void create() {
        GameModule gameModule = new GameModule(this);

        gameComponent = DaggerGameComponent.builder().gameModule(gameModule).build();
        gameComponent.inject(this);

        screenComponent = DaggerScreenComponent.builder().screenModule(new ScreenModule()).gameModule(gameModule).gameComponent(gameComponent).build();
        setScreen(screenComponent.createLoadingScreen());
    }

    public ScreenComponent getScreenComponent() {
        return screenComponent;
    }
}