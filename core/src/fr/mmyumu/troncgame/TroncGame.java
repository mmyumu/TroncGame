package fr.mmyumu.troncgame;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

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
        Gdx.app.setLogLevel(Application.LOG_DEBUG);
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