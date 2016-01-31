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

/**
 * Main menu screen
 * Created by mmyumu on 24/10/2015.
 */
public class MainMenuScreen extends ScreenAdapter {
    private final TroncGame troncGame;
    private final ScalingViewport viewport;
    private MainMenu mainMenu;


    @Inject
    public MainMenuScreen(TroncGame troncGame, ScalingViewport viewport) {
        this.troncGame = troncGame;
        this.viewport = viewport;

        initStages();
    }

    private void initStages() {
        List<Actor> buttons = new ArrayList<Actor>();
        buttons.add(troncGame.getMainMenuComponent().createMainMenuContinue());
        buttons.add(troncGame.getMainMenuComponent().createMainMenuStart());

        MainMenuBackground mainMenuBackground = troncGame.getMainMenuComponent().createMainMenuBackground();

        mainMenu = troncGame.getMainMenuComponent().createMainMenu();
        mainMenu.init(mainMenuBackground, buttons);

        Gdx.input.setInputProcessor(mainMenu);
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
