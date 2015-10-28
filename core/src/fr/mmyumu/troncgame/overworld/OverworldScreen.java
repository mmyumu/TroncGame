package fr.mmyumu.troncgame.overworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;

import javax.inject.Inject;

import fr.mmyumu.troncgame.TroncGame;

/**
 * Created by mmyumu on 28/10/2015.
 */
public class OverworldScreen extends ScreenAdapter {
    private static final String TAG = "OverworldScreen";

    private final TroncGame troncGame;

    public OverworldScreen(TroncGame troncGame) {
        this.troncGame = troncGame;
    }

    @Override
    public void show() {
        Gdx.app.debug(TAG, "Showing Overworld");
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


    }
}