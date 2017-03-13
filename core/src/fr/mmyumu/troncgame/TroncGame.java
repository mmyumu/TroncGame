package fr.mmyumu.troncgame;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;

import fr.mmyumu.troncgame.components.DaggerModelComponent;
import fr.mmyumu.troncgame.components.FightComponent;
import fr.mmyumu.troncgame.components.GameComponent;
import fr.mmyumu.troncgame.components.IntroductionComponent;
import fr.mmyumu.troncgame.components.MainMenuComponent;
import fr.mmyumu.troncgame.components.ModelComponent;
import fr.mmyumu.troncgame.components.OverworldComponent;
import fr.mmyumu.troncgame.modules.FightModule;
import fr.mmyumu.troncgame.modules.GameModule;
import fr.mmyumu.troncgame.modules.MainMenuModule;
import fr.mmyumu.troncgame.modules.ModelModule;
import fr.mmyumu.troncgame.modules.OverworldModule;

public class TroncGame extends Game {
    private final ModelComponent modelComponent;
    private final GameComponent gameComponent;
    private final MainMenuComponent mainMenuComponent;
    private final OverworldComponent overworldComponent;
    private final FightComponent fightComponent;
    private final IntroductionComponent introductionComponent;

    public TroncGame() {
        ModelModule modelModule = new ModelModule();
        GameModule gameModule = new GameModule(this);
        FightModule fightModule = new FightModule();
        MainMenuModule mainMenuModule = new MainMenuModule();
        OverworldModule overworldModule = new OverworldModule();

        modelComponent = DaggerModelComponent.builder().modelModule(modelModule).build();
        gameComponent = modelComponent.createGameComponent(gameModule);
        fightComponent = gameComponent.createFightComponent(fightModule);
        mainMenuComponent = gameComponent.createMainMenuComponent(mainMenuModule);
        overworldComponent = gameComponent.createOverworldComponent(overworldModule);
        introductionComponent = gameComponent.createIntroductionComponent();
    }

    @Override
    public void create() {
        Gdx.app.setLogLevel(Application.LOG_DEBUG);
        setScreen(gameComponent.loadingScreen());
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

    public ModelComponent getModelComponent() {
        return modelComponent;
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

    public IntroductionComponent getIntroductionComponent() {
        return introductionComponent;
    }
}