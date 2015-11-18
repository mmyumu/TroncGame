package fr.mmyumu.troncgame;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

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
    }

    @Override
    public void create() {
        Gdx.app.setLogLevel(Application.LOG_DEBUG);
        GameModule gameModule = new GameModule(this);

        gameComponent = DaggerGameComponent.builder().gameModule(gameModule).build();
        gameComponent.inject(this);

        mainMenuComponent = DaggerMainMenuComponent.builder().mainMenuModule(new MainMenuModule()).gameModule(gameModule).gameComponent(gameComponent).build();
        overworldComponent = DaggerOverworldComponent.builder().overworldModule(new OverworldModule()).gameModule(gameModule).gameComponent(gameComponent).build();
        fightComponent = DaggerFightComponent.builder().fightModule(new FightModule()).gameModule(gameModule).gameComponent(gameComponent).build();

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
}