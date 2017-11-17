package fr.mmyumu.troncgame.menu.main;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.viewport.ScalingViewport;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import fr.mmyumu.troncgame.TroncGame;
import fr.mmyumu.troncgame.persistence.GameStatePersister;

/**
 * Main menu screen
 * Created by mmyumu on 24/10/2015.
 */
public class MainMenuScreen extends ScreenAdapter {
    private final TroncGame troncGame;
    private final ScalingViewport viewport;
    private final GameStatePersister gameStatePersister;
    private MainMenu mainMenu;


    @Inject
    public MainMenuScreen(TroncGame troncGame, ScalingViewport viewport, GameStatePersister gameStatePersister) {
        this.troncGame = troncGame;
        this.viewport = viewport;
        this.gameStatePersister = gameStatePersister;
    }

    @Override
    public void show() {
        super.show();
        initStages();
    }

    private void initStages() {
        List<Actor> buttons = new ArrayList<>();
        buttons.add(troncGame.getMainMenuComponent().createMainMenuStart());

        if(gameStatePersister.hasSavedGame()) {
            buttons.add(troncGame.getMainMenuComponent().createMainMenuContinue());
        }

        MainMenuBackground mainMenuBackground = troncGame.getMainMenuComponent().createMainMenuBackground();

        mainMenu = troncGame.getMainMenuComponent().createMainMenu();
        mainMenu.init(mainMenuBackground, buttons);

        troncGame.setInputProcessors(mainMenu);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        mainMenu.draw();
    }

    @Override
    public void hide() {
        Gdx.input.setInputProcessor(null);
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
    }
}
