package fr.mmyumu.troncgame;

import com.badlogic.gdx.Game;

import javax.inject.Singleton;

@Singleton
public class TroncGame extends Game {

    private GameComponent gameComponent;
    private ScreenComponent screenComponent;

    public TroncGame() {
    }

    @Override
    public void create() {
//        setupGraph();
        GameModule gameModule = new GameModule(this);
        gameComponent = DaggerGameComponent.builder().gameModule(gameModule).build();
        gameComponent.inject(this);

        screenComponent = DaggerScreenComponent.builder().screenModule(new ScreenModule()).gameModule(gameModule).gameComponent(gameComponent).build();
        setScreen(screenComponent.createLoadingScreen());
//        screenComponent = DaggerScreenComponent.create();
//        LoadingScreen loadingScreen = screenComponent.createLoadingScreen();
//        setScreen(loadingScreen);
//        TroncGameComponent troncGameComponent = DaggerTroncGameComponent.create();
//        TroncGame troncGame = troncGameComponent.createTroncGame();
    }

    private void setupGraph() {
        gameComponent = DaggerGameComponent.builder().gameModule(new GameModule(this)).build();
        gameComponent.inject(this);
    }

//    public ScreenComponent getScreenComponent() {
//        return screenComponent;
//    }


    public ScreenComponent getScreenComponent() {
        return screenComponent;
    }
}