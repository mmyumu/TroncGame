package fr.mmyumu.troncgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import javax.inject.Inject;

/**
 * Created by mmyumu on 24/10/2015.
 */
public class MainMenuScreen extends ScreenAdapter {

    private SpriteBatch batch;
    private Texture mainMenu;

    private TroncGame troncGame;
    private AssetManager assetManager;

    @Inject
    public MainMenuScreen(TroncGame troncGame, AssetManager assetManager) {
        this.troncGame = troncGame;
        this.assetManager = assetManager;
    }

    @Override
    public void render(float delta) {

        System.out.println("### Main Menu Screen");

        Gdx.gl.glClearColor(0, 1, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(mainMenu, 0, 0);
        batch.end();
    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        mainMenu = assetManager.get("main_menu.png", Texture.class);
    }
}
