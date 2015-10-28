package fr.mmyumu.troncgame.menu.main;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.ScalingViewport;

import javax.inject.Inject;

import fr.mmyumu.troncgame.Constants;
import fr.mmyumu.troncgame.TroncGame;

/**
 * Main menu screen
 * Created by mmyumu on 24/10/2015.
 */
public class MainMenuScreen extends ScreenAdapter {
    private final TroncGame troncGame;
    private Stage stage;


    @Inject
    public MainMenuScreen(TroncGame troncGame) {
        this.troncGame = troncGame;
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.draw();
    }

    @Override
    public void show() {
        stage = new Stage(new ScalingViewport(Scaling.fit, Constants.WIDTH, Constants.HEIGHT));
        MainMenuActor mainMenuActor = troncGame.getScreenComponent().createMainMenuActor();
        stage.addActor(mainMenuActor);
        Gdx.input.setInputProcessor(mainMenuActor);
    }

    @Override
    public void hide() {
        Gdx.input.setInputProcessor(null);
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height);
    }
}
