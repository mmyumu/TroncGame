package fr.mmyumu.troncgame;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;

import javax.inject.Singleton;

import fr.mmyumu.troncgame.components.DaggerFightComponent;
import fr.mmyumu.troncgame.components.DaggerGameComponent;
import fr.mmyumu.troncgame.components.DaggerMainMenuComponent;
import fr.mmyumu.troncgame.components.DaggerOverworldComponent;
import fr.mmyumu.troncgame.components.FightComponent;
import fr.mmyumu.troncgame.components.GameComponent;
import fr.mmyumu.troncgame.components.MainMenuComponent;
import fr.mmyumu.troncgame.components.OverworldComponent;
import fr.mmyumu.troncgame.modules.FightModule;
import fr.mmyumu.troncgame.modules.GameModule;
import fr.mmyumu.troncgame.modules.MainMenuModule;
import fr.mmyumu.troncgame.modules.OverworldModule;

@Singleton
public class TroncGame extends Game {

    private GameComponent gameComponent;
    private MainMenuComponent mainMenuComponent;
    private OverworldComponent overworldComponent;
    private FightComponent fightComponent;

    public TroncGame() {
        GameModule gameModule = new GameModule(this);

        gameComponent = DaggerGameComponent.builder().gameModule(gameModule).build();
        gameComponent.inject(this);

        mainMenuComponent = DaggerMainMenuComponent.builder().mainMenuModule(new MainMenuModule()).gameModule(gameModule).gameComponent(gameComponent).build();
        overworldComponent = DaggerOverworldComponent.builder().overworldModule(new OverworldModule()).gameModule(gameModule).gameComponent(gameComponent).build();
        fightComponent = DaggerFightComponent.builder().fightModule(new FightModule()).gameModule(gameModule).gameComponent(gameComponent).build();
    }

    @Override
    public void create() {
        Gdx.app.setLogLevel(Application.LOG_DEBUG);
        setScreen(mainMenuComponent.createMainMenuLoadingScreen());
    }

    public MainMenuComponent getMainMenuComponent() {
        return mainMenuComponent;
    }

    public OverworldComponent getOverworldComponent() {
        return overworldComponent;
    }

    public FightComponent getFightComponent() {
        return fightComponent;
    }

    public void setInputProcessors(InputProcessor... inputProcessors) {
        GameInputProcessor gameInputProcessor = gameComponent.createGameInputProcessor();
        InputMultiplexer multiplexer = new InputMultiplexer();
        multiplexer.addProcessor(gameInputProcessor);

        for (InputProcessor inputProcessor : inputProcessors) {
            multiplexer.addProcessor(inputProcessor);
        }

        Gdx.input.setInputProcessor(multiplexer);
    }
}